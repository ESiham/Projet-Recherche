package fr.ifsttar.licit.simulator.network.connection.socket;

import java.net.Socket;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ifsttar.licit.simulator.network.simulation.util.Component;


public abstract class AbstractSocketListener implements Component {

	
	 /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractSocketListener.class);
	
	protected static class StopListeningException extends Exception {
		private static final long serialVersionUID = -4787588718053398042L;}

	protected abstract void stopListening();
	protected abstract Socket waitForIncomingSocket() throws StopListeningException;
	
	private Thread listenthread;
	private SocketHandler socketHandler;
	
	public AbstractSocketListener() {
		listenthread = new Thread(){
			public void run() {
				try {
					while (true) {
						final Socket s = waitForIncomingSocket();
						Thread t = new Thread() {
							public void run() {
								if (socketHandler!=null) {
									socketHandler.handleSocket(s);
								}
							}
						};
						t.start();
					}
				} catch (StopListeningException e) {
					LOG.debug("caught StopListeningException");
				}
			}
		};
	}
	
	
	
	public void start() {
		listenthread.start();
	}

	public void stop() {
		stopListening();
	}
	
	public SocketHandler getSocketHandler() {
		return socketHandler;
	}
	public void setSocketHandler(SocketHandler socketHandler) {
		this.socketHandler = socketHandler;
	}
}
