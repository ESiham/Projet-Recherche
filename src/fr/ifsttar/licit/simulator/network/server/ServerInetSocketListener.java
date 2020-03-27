package fr.ifsttar.licit.simulator.network.server;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.ifsttar.licit.simulator.network.configuration.InvalidConfigurationException;
import fr.ifsttar.licit.simulator.network.connection.socket.InetSocketListener;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLUtilities;

public class ServerInetSocketListener {
	
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ServerInetSocketListener.class);
	
	public final int AGENT_PORT_DEFAULT=12300; 
	public final int AGENT_BACKLOG_DEFAULT=10; 
	
	public InetSocketListener object;
	
	public ServerInetSocketListener(Element xml) throws InvalidConfigurationException { 
		//network configuration
		int agent_port=AGENT_PORT_DEFAULT;
		int agent_backlog=AGENT_BACKLOG_DEFAULT;
		
		NodeList nl=XMLUtilities.getChildsByTagName(xml, "network-agent");
		if (nl.getLength()==1) {
			try {
				int v=Integer.parseInt(((Element)nl.item(0)).getAttribute("port"));agent_port=v;
			} catch (NumberFormatException e) {
				throw new InvalidConfigurationException("unable to parse agent port from configuration");
			}
			try {
				int v=Integer.parseInt(((Element)nl.item(0)).getAttribute("backlog"));agent_backlog=v;
			} catch (NumberFormatException e) {
				throw new InvalidConfigurationException("unable to parse agent backlog from configuration");
			}
		}
		
		//create socket listener
		InetSocketListener socketlistener = null;
		try {
			object = new InetSocketListener(agent_port,agent_backlog,null);
		} catch (IOException e) {
			LOG.error("IO Error while creating InetSocketListener. Aborting...");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public ServerInetSocketListener() throws InvalidConfigurationException { 
		
		int agent_port=AGENT_PORT_DEFAULT;
		int agent_backlog=AGENT_BACKLOG_DEFAULT;
		
		try {
			object = new InetSocketListener(agent_port,agent_backlog,null);
		} catch (IOException e) {
			LOG.error("IO Error while creating InetSocketListener. Aborting...");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
