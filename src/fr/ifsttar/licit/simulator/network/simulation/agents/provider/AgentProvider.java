package fr.ifsttar.licit.simulator.network.simulation.agents.provider;

import fr.ifsttar.licit.simulator.network.simulation.agents.AbstractSimulationAgent;
import fr.ifsttar.licit.simulator.network.simulation.agents.AgentParameter;

/**
 * This interface offers methods to retrieve a set of agents from the implementing object and to allocate agents from it.
 * Those agents won't be available until they are removed via SimulationAgent.remove().
 */
public interface AgentProvider {
	
	/**
	 * Retrieve a list of available agents, fulfilling requirements as mentioned in agentparameter;
	 * @param p requirements the returned agents should fulfill.
	 * @return an array of suitable agents
	 */
	AbstractSimulationAgent[] getAgents(AgentParameter agentparameter);
	
	/**
	 * Allocate an agent. This means that it won't be offered anymore via getAgents until the agent is removed via it's remove method.
	 * @param agent to allocate.
	 */
	void allocateAgent(AbstractSimulationAgent agent);
	
	/**
	 * Free an agent
	 */
	void freeAgent(AbstractSimulationAgent agent);
}
