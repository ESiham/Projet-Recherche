package fr.ifsttar.licit.simulator.network.server;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ifsttar.licit.simulator.agents.action.InvalidAction;
import fr.ifsttar.licit.simulator.agents.action.infrastructure.ChangeColorRSU;
import fr.ifsttar.licit.simulator.agents.action.infrastructure.RoadSideUnitAction;
import fr.ifsttar.licit.simulator.agents.action.vehicles.ChangeColorAction;
import fr.ifsttar.licit.simulator.agents.action.vehicles.VehicleAction;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;
import fr.ifsttar.licit.simulator.network.configuration.InvalidConfigurationException;
import fr.ifsttar.licit.simulator.network.connection.XMLSocketSimulationAgent;
import fr.ifsttar.licit.simulator.network.connection.authentication.Account;
import fr.ifsttar.licit.simulator.network.connection.authentication.UsernamePasswordAccount;
import fr.ifsttar.licit.simulator.network.connection.socket.SocketHandler;
import fr.ifsttar.licit.simulator.network.simulation.agents.AbstractSimulationAgent;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec;

public class ServerSimulationAgents {

	public AbstractSimulationAgent[] agents;
	public List<Account> accounts;

	public Map<Account, SocketHandler> accountSocketHandlerMap;


	public ServerSimulationAgents(List<RoadSideUnit> rsus) throws InvalidConfigurationException {


		if(rsus!=null){

			int accountlistlen =0;
			for(RoadSideUnit rsu : rsus){

				if(rsu.isExternalControl())
					accountlistlen++;
			}


			//init fields
			agents = new AbstractSimulationAgent[accountlistlen];

			accounts = new ArrayList<Account>();//new Account[accountlistlen];


			accountSocketHandlerMap = new HashMap<Account, SocketHandler>();

			int i=0;
			for(RoadSideUnit rsu : rsus){

				if(rsu.isExternalControl()){

					String username="RSU" + rsu.getId();
					String password="1";
					int timeout = 10;
					int auxtimeout = 0;
					int maxpacketlength = 65536;

					XMLSocketSimulationAgent agent = (XMLSocketSimulationAgent) rsu.getXmlSocketSimulationAgent();//new XMLSocketSimulationAgent(); 
					UsernamePasswordAccount account = new UsernamePasswordAccount(username,password);

					agents[i] = agent; 
					accounts.add(account);

					accountSocketHandlerMap.put(account,agent);

					agent.setIdentifier(account);
					agent.setMaximumPacketLength(maxpacketlength);
					agent.setTimeout(timeout);
					agent.setAuxiliaryTimeout(auxtimeout);

					XMLCodec.DefaultXMLToObjectConverter xmlToObjectConverter = new XMLCodec.DefaultXMLToObjectConverter();
					
					
					Map<String,Class> actionClassMap = new HashMap<String, Class>();
					actionClassMap.put("RoadSideUnitAction", RoadSideUnitAction.class);
					/*
					 * add for TP
					 */
					actionClassMap.put("ChangeColorRSU", ChangeColorRSU.class);
										
					xmlToObjectConverter.setClassMap(actionClassMap);
					xmlToObjectConverter.setDefaultClass(InvalidAction.class);		
					agent.setXmlToObjectConverter(xmlToObjectConverter);
				}

				i++;
			}
		}
	}

	public void addVehicleAgent(long id, final XMLSocketSimulationAgent agent){

		//System.out.println("id = " + id + " agent =" + agent);
		 
		//init fields
		agents = Arrays.copyOf(agents, agents.length + 1);

		//accounts = Arrays.copyOf(accounts, accounts.length + 1);

		String username="VEHICLE" + id;

		String password="1";

		int timeout = 10;

		int auxtimeout = 0;
		int maxpacketlength = 65536;

		UsernamePasswordAccount account = new UsernamePasswordAccount(username,password);

		agents[agents.length-1] = agent; 
		
		//accounts[accounts.length-1] = account;
		accounts.add(account);
		
		accountSocketHandlerMap.put(account,agent);

		//System.out.println("set identifier " + account.getUsername() + " for agent " + agent);
		agent.setIdentifier(account);
		agent.setMaximumPacketLength(maxpacketlength);
		agent.setTimeout(timeout);
		agent.setAuxiliaryTimeout(auxtimeout);

		XMLCodec.DefaultXMLToObjectConverter xmlToObjectConverter = new XMLCodec.DefaultXMLToObjectConverter();
		
		
		Map<String,Class> actionClassMap = new HashMap<String, Class>();
		actionClassMap.put("VehicleAction", VehicleAction.class);
		actionClassMap.put("ChangeColorAction", ChangeColorAction.class);
		//actionClassMap.put("InvalidAction", InvalidAction.class);
		
		xmlToObjectConverter.setClassMap(actionClassMap);

		xmlToObjectConverter.setDefaultClass(InvalidAction.class);
	
		agent.setXmlToObjectConverter(xmlToObjectConverter);

		agent.start();

	}
}
