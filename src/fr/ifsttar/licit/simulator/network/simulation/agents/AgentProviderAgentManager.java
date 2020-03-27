package fr.ifsttar.licit.simulator.network.simulation.agents;

import java.util.concurrent.Future;

import fr.ifsttar.licit.simulator.agents.action.Action;
import fr.ifsttar.licit.simulator.agents.action.InvalidAction;
import fr.ifsttar.licit.simulator.agents.perception.Perception;
import fr.ifsttar.licit.simulator.network.simulation.agents.provider.AgentProvider;

/**
 * This agent manager will "create" agents by retrieving suitable agents from an agent provider.
 * If there is no suitable agent it will deliver a dummy agent that will always return an invalid action.
 *
 */
public class AgentProviderAgentManager extends DefaultAgentManager {

	private class SimulationAgentWrapper extends AbstractSimulationAgent {
		private AbstractSimulationAgent agent;
		public SimulationAgentWrapper(AbstractSimulationAgent agent) {
			this.agent=agent;
		}
		
		public Action getAction(Perception p) {
			return agent.getAction(p);
		}

		public void remove() {
			agentProvider.freeAgent(agent);
			agent.remove();
		}

		public Future<Action> concurrentGetAction(Perception perception) {
			return agent.concurrentGetAction(perception);
		}

		public Object getIdentifier() {
			return agent.getIdentifier();
		}
	}

	
	private AgentProvider agentProvider;

	/**
	 * Creates a new AgentProviderAgentManager based upon an AgentProvider.
	 * @param agentProvider provider of agents to be returned.
	 */
	public AgentProviderAgentManager(AgentProvider agentProvider) {
		this.agentProvider = agentProvider;
	}
	public AgentProviderAgentManager() {
		this.agentProvider = null;
	}
	
	public AgentProvider getAgentProvider() {return agentProvider;}
	public void setAgentProvider(AgentProvider p) {agentProvider=p;}
	/* (non-Javadoc)
	 * @see massim.framework.AgentManager#createAgent(massim.framework.AgentParameter)
	 */
	@Override
	public SimulationAgent createAgent(AgentParameter parameter) {
		AbstractSimulationAgent[] a = agentProvider.getAgents(parameter);
		synchronized(agentProvider) {
			if (a.length>0) {
				agentProvider.allocateAgent(a[0]);
				return new SimulationAgentWrapper(a[0]);
			} else
			return new DummyAgent();
		}
	}
	
	private class DummyAgent extends AbstractSimulationAgent {
		public Action getAction(Perception p) {
			return new InvalidAction();
		}
		public void remove() {}
		/* (non-Javadoc)
		 * @see massim.framework.AbstractSimulationAgent#getIdentifier()
		 */
		@Override
		public Object getIdentifier() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
