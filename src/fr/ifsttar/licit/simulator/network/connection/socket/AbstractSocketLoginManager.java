package fr.ifsttar.licit.simulator.network.connection.socket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ifsttar.licit.simulator.network.connection.authentication.Account;
import fr.ifsttar.licit.simulator.network.connection.authentication.Authentication;

public abstract class AbstractSocketLoginManager implements SocketHandler {
	
	 /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractSocketLoginManager.class);
	
	
	private List<Account> accounts;
	private Map<Account, SocketHandler> socketHandlerMap;
	
	public AbstractSocketLoginManager(List<Account> accounts, Map<Account, SocketHandler> socketHandlerMap) {
		this.accounts = accounts;
		this.socketHandlerMap = socketHandlerMap;
	}
	public AbstractSocketLoginManager() {
		setAccountSocketHandlerMap(new HashMap<Account,SocketHandler>());
	}
	public Map<Account, SocketHandler> getAccountSocketHandlerMap() {
		return socketHandlerMap;
	}
	
	public void setAccountSocketHandlerMap(Map<Account, SocketHandler> v) {
		socketHandlerMap = v;
		Set<Account> s = v.keySet();
		accounts = new ArrayList<Account>();
		accounts.addAll(s);//s.s.toArray(new Account[s.size()]);
	}
	
	public void handleSocket(Socket s) {
		
		Authentication auth = getAuthentication(s);
		int i;
		do
			for (i=0; i<accounts.size(); i++) {
				Account iacc = accounts.get(i);
				if (iacc.authenticate(auth)) {
					SocketHandler handler = socketHandlerMap.get(iacc);
					handleValidAuthentication(s);
					handler.handleSocket(s);
					return;
				}
			}
		while (handleInvalidAuthentication(s));
	}

	/**
	 * This method is called to receive a new Authentification implementing object for a connection.
	 * @param c the connection
	 * @return Authentication associated to connection.
	 */
	abstract protected Authentication getAuthentication(Socket s);
	
	/**
	 * This method is called when an agent did not authenticate.
	 * @param s socket
	 */
	abstract protected boolean handleInvalidAuthentication(Socket s);
	abstract protected void handleValidAuthentication(Socket s);
}
