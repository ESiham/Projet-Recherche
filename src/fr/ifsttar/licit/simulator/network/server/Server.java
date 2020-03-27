package fr.ifsttar.licit.simulator.network.server;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.movsim.simulator.vehicles.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;
import fr.ifsttar.licit.simulator.network.configuration.InvalidConfigurationException;
import fr.ifsttar.licit.simulator.network.connection.XMLSocketSimulationAgent;
import fr.ifsttar.licit.simulator.network.connection.socket.InetSocketListener;
import fr.ifsttar.licit.simulator.network.connection.socket.UsernamePasswordSocketLoginManager;
import fr.ifsttar.licit.simulator.network.simulation.agents.AgentManager;
import fr.ifsttar.licit.simulator.network.simulation.agents.AgentProviderAgentManager;
import fr.ifsttar.licit.simulator.network.simulation.agents.provider.AgentProvider;
import fr.ifsttar.licit.simulator.network.simulation.agents.provider.ArrayAgentProvider;
import fr.ifsttar.licit.simulator.network.simulation.util.Component;


public class Server extends AbstractServer {
	
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(Server.class);
	
	public final int AGENT_PORT_DEFAULT=12300; 
	public final int AGENT_BACKLOG_DEFAULT=10;

	public int  score[];
	protected InetSocketListener socketlistener;
	protected ServerInetSocketListener serverinetsocketlistener;
	protected ServerSimulationAgents serversimulationagents;
	protected UsernamePasswordSocketLoginManager loginsocketmanager;
	protected ArrayAgentProvider arrayagentprovider;
	protected AgentManager agentmanager;
	protected AgentProvider agentProvider;

	
	protected LaunchSync launchSync;
	
	
	private enum Serverstatus {
		NOTCONFIGURED, CONFIGURED, SIMSTART, SIMSTOP, SIMEND
	}
	
	private Serverstatus serverstatus;
	
	interface LaunchSync {
		void waitForStart();
	}
	
	class TimerLaunchSync implements LaunchSync {
		long time;
		public TimerLaunchSync(Element e) {
			this.time = Long.parseLong(e.getAttribute("time-to-launch"));
		}
		public void waitForStart() {
			try {
				LOG.info("The tournament will start in " + this.time + " milliseconds");
				Thread.sleep(this.time);
			} catch (InterruptedException e) {}
		}
	}
	
	class KeyLaunchSync implements LaunchSync {
		public void waitForStart() {
			try {
				LOG.info("Please press ENTER to start the tournament.");
				System.in.read();
			} catch (IOException e) {}
		}
	}
	
	class DirectLaunchSync implements LaunchSync {
		public void waitForStart() {
			
		}
	}
	
	class LaunchAtTimeSync implements LaunchSync {
		long time = 0;
		long diffTime = 0;
		public LaunchAtTimeSync(Element e) {
			DateFormat timeFormat;
			timeFormat = new SimpleDateFormat("HH:mm");
			Calendar cal = Calendar.getInstance();
			LOG.info("Current time is: " + cal.getTime().toString());
			try {				
				Calendar startDate = Calendar.getInstance();
				Date d = timeFormat.parse(e.getAttribute("time"));
				startDate.setTime(d);
				int hourOfDay = startDate.get(Calendar.HOUR_OF_DAY);
				int minute = startDate.get(Calendar.MINUTE);;
				startDate.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), hourOfDay, minute);
				LOG.info("Starting time: " + startDate.getTime().toString());
				this.time = startDate.getTimeInMillis();
				this.diffTime = this.time - cal.getTimeInMillis();
				if (this.diffTime < 0) {
					this.diffTime = 0;
				}
			} catch (ParseException e1) {
				LOG.error("Error while parsing start time");
				System.exit(1);
			}
		}
		public void waitForStart() {
			try {
				LOG.info("The server will start in: " + this.diffTime + " milliseconds from now on");
				Thread.sleep(this.diffTime);
			} catch (InterruptedException e) {}
		}
		
	}
	
	public Server(){
		this.serverstatus = Serverstatus.NOTCONFIGURED;
	}
	
	public Server(int agent_port, int backlog_port,List<RoadSideUnit> rsus) throws InvalidConfigurationException {
		this.config(agent_port,backlog_port, rsus);
		this.serverstatus = Serverstatus.CONFIGURED;
		LOG.debug("Server configured.");
	}
	
public void config(int agent_port, int backlog_port, List<RoadSideUnit> rsus) throws InvalidConfigurationException {
	
		LOG.debug("Server launched.");

		//create socket listener
		this.serverinetsocketlistener = new ServerInetSocketListener();
		this.socketlistener = this.serverinetsocketlistener.object;
		
		//read account list
		this.serversimulationagents = new ServerSimulationAgents(rsus);
		//create UsernamePasswordSocketLoginManager 
		this.loginsocketmanager = new UsernamePasswordSocketLoginManager(this.serversimulationagents.accounts,this.serversimulationagents.accountSocketHandlerMap);

		//connect loginsocketmanager with socketlistener
		this.socketlistener.setSocketHandler(this.loginsocketmanager);
		
		//create arrayagentprovider
		this.arrayagentprovider = new ArrayAgentProvider(this.serversimulationagents.agents);

		//create agent manager
		this.agentmanager = new AgentProviderAgentManager(this.arrayagentprovider);
		
		//create launch sync
		this.launchSync = new DirectLaunchSync();//new KeyLaunchSync();
		
		this.serverstatus = Serverstatus.CONFIGURED;
	}


	
	public void run() throws InvalidConfigurationException {
	
		this.serverstatus = Serverstatus.SIMSTART;
		
		this.agentmanager.start();
		
		for (int i=0;i<this.serversimulationagents.agents.length;i++) 
			((Component)this.serversimulationagents.agents[i]).start();
		
		this.socketlistener.start();

		// launch synchronization
		this.launchSync.waitForStart();
	
	}
	
	public synchronized void stopSimulation() {
		
		this.socketlistener.stop();
		for (int i=0;i<this.serversimulationagents.agents.length;i++) 
			((Component)this.serversimulationagents.agents[i]).stop();
		this.agentmanager.stop();
		
		this.serverstatus = Serverstatus.SIMEND;
	}
	
	
	public void addVehicleAgent(Vehicle v){
		if(serversimulationagents!=null){
			serversimulationagents.addVehicleAgent(v.getId(),(XMLSocketSimulationAgent) v.getXmlSocketSimulationAgent());
		}
	}
}
