package fr.ifsttar.licit.simulator.network.simulation.agents;

import java.util.concurrent.Future;

import fr.ifsttar.licit.simulator.agents.action.Action;
import fr.ifsttar.licit.simulator.agents.perception.Perception;

/**
 * This interface must be implemented by every object that is used in simulation as an agent.
 *
 */
public abstract class SimulationAgent {
	/**
	 * Ask the agent to act, based a new perception p as well as other previously received perceptions in that run.
	 * @param p new perception
	 * @return action the agent wants to perform
	 */
	public abstract Action getAction(Perception p);
	
	/**
	 * Tell an agent that it was removed from the simulation and will never act again. Calling remove will also invalidate
	 * the agents knowledge about the world.
	 */
	public abstract void remove();

	/**
	 * Concurrent version of getAction.
	 * @param perception
	 * @return
	 */
	public abstract Future<Action> concurrentGetAction(final Perception perception);
}
