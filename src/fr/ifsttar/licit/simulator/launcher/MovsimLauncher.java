package fr.ifsttar.licit.simulator.launcher;

import javax.xml.bind.JAXBException;

import org.movsim.MovsimCoreMain;
import org.xml.sax.SAXException;

public class MovsimLauncher {

	public static void main(String[] args) throws JAXBException, SAXException {
		// TODO Auto-generated method stub
		for(int k = 0 ; k<args.length ; ++k){
			
			String command = "-f"+args[k];
			
			String[] commands = new String[1];
			commands[0] = command;
			
			MovsimCoreMain.main(commands);			
		}
	}

}
