package fr.ifsttar.licit.simulator.network.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.network.connection.socket.AbstractSocketLoginManager;
import fr.ifsttar.licit.simulator.network.connection.socket.AgentCodecProtocolErrorException;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec;


public class ConfigurationUtilities {

	 /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationUtilities.class);
	
	public static Class getClassFromConfig(String name) throws InvalidConfigurationException {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			LOG.error("Unable to find class:"+name);
			throw new InvalidConfigurationException(e);
		}
	}
	
	public static <T> T getNewInstanceFromConfig(String name) throws InvalidConfigurationException {
		Class cls = getClassFromConfig(name);
		Object result = null;
		try {
			result = cls.newInstance();
		} catch (IllegalAccessException e) {
			LOG.error("Unable to access class:"+name);
			throw new InvalidConfigurationException(e);
		} catch (InstantiationException e) {
			LOG.error("Unable to instantiate class:"+name);
			throw new InvalidConfigurationException(e);
		}
		return (T)result;
	}
	
	public static <T> T getObjectFromConfig(String name, Element source) throws InvalidConfigurationException {
		Object result = null;
		Class cls = getClassFromConfig(name);
		try {
			result = XMLCodec.convertXMLToObject(source,cls);
		} catch (InstantiationException e) {
			LOG.error("Unable to instantiate class:"+name);
			throw new InvalidConfigurationException(e);
		} catch (IllegalAccessException e) {
			LOG.error("Unable to access class:"+name);
			throw new InvalidConfigurationException(e);
		} catch (AgentCodecProtocolErrorException e) {
			LOG.error("Error while parsing data for class:"+name);
			throw new InvalidConfigurationException(e);
		}
		return (T)result;
	}
}
