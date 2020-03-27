package fr.ifsttar.licit.simulator.launcher;

import java.util.Vector;

import javax.xml.bind.JAXBException;

import org.movsim.MovsimCoreMain;
import org.xml.sax.SAXException;

public class MovsimThreadedLauncher {

	public static void main(String[] args) throws JAXBException, SAXException {
		// TODO Auto-generated method stub
		
		Vector<Thread> threads = new Vector<Thread>();
		
		
		for(int k = 0 ; k<args.length ; ++k){
			
			String command = "-f"+args[k];
			
			final String[] commands = new String[1];
			commands[0] = command;
			
			
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						MovsimCoreMain movsim = new MovsimCoreMain();
						movsim.main(commands);
					} catch (JAXBException | SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
			threads.add(thread);
		
		}
		
		for(Thread thread : threads){
			try {
				
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
