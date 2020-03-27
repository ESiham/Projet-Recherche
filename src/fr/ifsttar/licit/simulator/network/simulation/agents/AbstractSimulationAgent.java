package fr.ifsttar.licit.simulator.network.simulation.agents;

import java.util.concurrent.Future;

import fr.ifsttar.licit.simulator.agents.action.Action;
import fr.ifsttar.licit.simulator.agents.perception.Perception;
import fr.ifsttar.licit.simulator.network.simulation.util.FutureObject;

public abstract class AbstractSimulationAgent extends SimulationAgent {
	@SuppressWarnings("unchecked")
	public Future<Action> concurrentGetAction(final Perception perception) {
		final FutureObject<Action> f = new FutureObject<Action>();
		new Thread(){public void run() {
			f.deliver(getAction(perception));
		}}.start();
		return f;
	}
	
	public abstract Object getIdentifier();
}
