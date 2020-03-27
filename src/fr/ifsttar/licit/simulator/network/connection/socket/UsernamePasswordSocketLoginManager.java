package fr.ifsttar.licit.simulator.network.connection.socket;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.ifsttar.licit.simulator.network.connection.authentication.Account;
import fr.ifsttar.licit.simulator.network.connection.authentication.Authentication;
import fr.ifsttar.licit.simulator.network.connection.authentication.UsernamePasswordAuthentication;

public class UsernamePasswordSocketLoginManager extends
		AbstractSocketLoginManager {

	 /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(UsernamePasswordSocketLoginManager.class);
	
	
	public UsernamePasswordSocketLoginManager(List<Account> accounts, Map<Account, SocketHandler> socketHandlerMap) {
		super(accounts,socketHandlerMap);
	}

	@Override
	protected Authentication getAuthentication(Socket s) {
		
		LOG.debug("retrieving authentication from client ");
		DocumentBuilder documentbuilder;
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			documentbuilder=factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {throw new RuntimeException(e);}
		UsernamePasswordAuthentication auth = new UsernamePasswordAuthentication();
		String logindocstring="";
		String user="";
		String pass="";
		try {
			InputStream is = s.getInputStream();
			byte b[]=new byte[1];
			do {
				b[0]=(byte)is.read();
				if (b[0]==0) break; else logindocstring+=(new String(b,0,1,"UTF-8"));
			} while (true);
			LOG.debug(logindocstring);
			Document logindoc=documentbuilder.parse(new ByteArrayInputStream(logindocstring.getBytes()));
			NodeList nl=logindoc.getElementsByTagName("authentication");
			if (nl.getLength()==0) {
				LOG.error("parse error while processing authentication");
				return auth;
			}
			Element root=(Element)nl.item(0);
			user=root.getAttribute("username");
			pass=root.getAttribute("password");
		} catch (IOException e) {
			LOG.error("IO error while receiving authentication");
			e.printStackTrace();
		} catch (SAXException e) {
			LOG.error("parse error while processing authentication");
			e.printStackTrace();
		}
		String addr = s.getInetAddress().getHostAddress();
		LOG.debug("got authentication: username="+user+" password="+pass+" Address="+addr);
		auth.username=user;
		auth.password=pass;
		return auth;
	}

	@Override
	protected boolean handleInvalidAuthentication(Socket s) {
		LOG.error("Server gets InvalidAuthentication from: "+ s.getInetAddress().getHostAddress());
		sendAuthResponse(s,false);
		try {
			s.close();
		} catch (IOException e) {
			LOG.error("Error while closing socket/sending invalid authentication error for a socket that provided invalid authentication.");
		}
		return false;
	}

	@Override
	protected void handleValidAuthentication(Socket s) {
		sendAuthResponse(s,true);
	}
	
	private void sendAuthResponse(Socket s, boolean result) {
		try {
			OutputStream out = s.getOutputStream();
			Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element el_root = doc.createElement("message");
			el_root.setAttribute("type","auth-response");
			long timestamp = System.currentTimeMillis();
			el_root.setAttribute("timestamp",""+timestamp);
			doc.appendChild(el_root);
			Element el_auth = doc.createElement("authentication");
			el_auth.setAttribute("result",result?"ok":"fail");
			el_root.appendChild(el_auth);
			
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc),new StreamResult(out));
			out.write(0);
		} catch (IOException e) {
			LOG.error("Error while closing socket/sending invalid authentication error for a socket that provided invalid authentication.");
		} catch (ParserConfigurationException e) {throw new RuntimeException(e);} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
}
