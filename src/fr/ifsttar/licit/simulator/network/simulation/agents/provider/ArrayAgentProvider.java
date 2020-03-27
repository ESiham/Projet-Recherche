package fr.ifsttar.licit.simulator.network.simulation.agents.provider;

import java.util.Vector;

import fr.ifsttar.licit.simulator.network.simulation.agents.AbstractSimulationAgent;
import fr.ifsttar.licit.simulator.network.simulation.agents.AgentParameter;
import fr.ifsttar.licit.simulator.network.simulation.util.Component;

/**
 * This class is able to serve as an AgentProvider. It will provide agents that were given
 * to it by an array.
 *
 */

public class ArrayAgentProvider implements AgentProvider, Component {
	private Vector<AbstractSimulationAgent> agents; // vector of available agents
	
	public ArrayAgentProvider() {
		this.agents = new Vector<AbstractSimulationAgent>();
	}
	
	public ArrayAgentProvider(AbstractSimulationAgent agents[]) {
		//add wrappers to initial agents and add them to a vector
		this.agents = new Vector<AbstractSimulationAgent>();
		for (int i=0;i<agents.length;i++) this.agents.add(agents[i]);
	}
	
	public AbstractSimulationAgent[] getAgents(AgentParameter agentparameter) {
		//convert vector to array and return it
		return agents.toArray(new AbstractSimulationAgent[0]);
	}

	public void setAgents(AbstractSimulationAgent agents[]) {
		this.agents = new Vector<AbstractSimulationAgent>();
		for (int i=0;i<agents.length;i++) this.agents.add(agents[i]);
	}
	
	public void allocateAgent(AbstractSimulationAgent agent) {
		agents.remove(agent);
	}

	public void freeAgent(AbstractSimulationAgent agent) {
		agents.add(agent);
	}

	public void start() {
	}

	public void stop() {
	}
}
