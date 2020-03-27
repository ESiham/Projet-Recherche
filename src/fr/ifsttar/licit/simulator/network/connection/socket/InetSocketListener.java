package fr.ifsttar.licit.simulator.network.connection.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ifsttar.licit.simulator.network.server.Server;

public class InetSocketListener extends AbstractSocketListener {
	
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(InetSocketListener.class);
	
	private ServerSocket serverSocket;
	public InetSocketListener(int port, int backlog, InetAddress inetaddr) throws IOException {
		LOG.info("InetSocketListener created. Set to port "+port+" with backlog "+backlog);
		serverSocket=new ServerSocket(port, backlog, inetaddr);
	}
	
	@Override
	protected void stopListening() {
		try{serverSocket.close();}
		catch(IOException e) {LOG.error(e.toString());}
	}

	@Override
	protected Socket waitForIncomingSocket() throws StopListeningException {
		while (true) {
			try {
				LOG.debug("waiting for connection...");
				Socket s=serverSocket.accept();
				LOG.debug("got a connection");
				return s;
			} catch (IOException e) {
				if (! serverSocket.isClosed()) LOG.error(e.toString());
				LOG.debug("stop listening");
				throw new StopListeningException();
			}
		}
	}

}
