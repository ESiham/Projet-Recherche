package fr.ifsttar.licit.simulator.agents.trust.models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import fr.ifsttar.licit.simulator.agents.communication.messages.TrustMessage;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.trust.models.base.TrustModel;
import fr.ifsttar.licit.simulator.agents.trust.models.parameters.TrustModelParameterTrustNet;
import fr.ifsttar.licit.simulator.agents.trust.representation.Tij;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;
import fr.ifsttar.licit.simulator.agents.trust.representation.TrustValue;

public class TrustNet extends TrustModel {

	// this vehicle is called vehicle "i"
	
	//computed direct trust values
	private Hashtable<Long, Double> DTijs = new Hashtable<Long, Double>();
	
	//shared trust values
	private ArrayList<Tij> Tkjs = new ArrayList<Tij>();
	
	//self trust shared values
	private ArrayList<Tij> Tkks = new ArrayList<Tij>();
	
	//shared values in this agent
	private ArrayList<Tij> Tkis = new ArrayList<Tij>();
	
	//computed indirect trust values
	Hashtable<Long, Double> ITijs = new Hashtable<Long, Double>();
	
	public TrustNet(TrustModelParameterTrustNet trustModelParameterTrustNet) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		DTijs.clear();
		Tkjs.clear();
		Tkks.clear();
		Tkis.clear();
		ITijs.clear();
	}

	@Override
	public void handleTrustMessage(TrustMessage trustMessage, long thisId, ArrayList<Long> sensedVehiclesIds) {
		if(trustMessage.getTij().getj() == thisId){
			Tkis.add(trustMessage.getTij());
		} else if(trustMessage.getTij().isSelfTrust()){
			Tkks.add(trustMessage.getTij());
			//System.out.println("Tkk");
		} else {
			for(Long id : sensedVehiclesIds){
				//get only interesting Tij
				if(id==trustMessage.getTij().getj())
					Tkjs.add(trustMessage.getTij());
			}
			//System.out.println("Tkj");
		}
	}

	@Override
	public void compareDirectInformation(Trust trust, SensedVehicle immediateFollower, double myPosition, double simulationTime) {
		
		DTijs.put(immediateFollower.getSenderId(), this.computeDirectTrustValue(immediateFollower, myPosition));
		
	}
	
	
	private Double computeDirectTrustValue(SensedVehicle immediateFollower, double myPosition) {
		
		//final double GPSDeltaX = Math.abs(immediateFollower.getAbsoluteX() - myPosition);
		
		//final double TelemeterDeltaX = Math.abs(immediateFollower.getRelativePosition());
		
		final double deltaXi = Math.abs(immediateFollower.getRelativePosition());
		
		final double Xi = myPosition;
		
		final double Xj = immediateFollower.getAbsoluteX();
		
		double error = Math.abs(deltaXi  + Xi - Xj) / (deltaXi + Xi);
		
		double directTrustValue = 1.0 - error;
		
		if(directTrustValue<0.0)
			directTrustValue=0.0;
		
		if(directTrustValue>1.0)
			directTrustValue=1.0;
	
    	return directTrustValue;
	}

	
//	private Double computeDirectTrustValue(SensedVehicle immediateFollower, double myPosition) {
//    		
//		final double GPSDeltaX = Math.abs(immediateFollower.getAbsoluteX() - myPosition);
//		
//		final double TelemeterDeltaX = Math.abs(immediateFollower.getRelativePosition());
//		
//	
//		
//		
//		double error = Math.abs(TelemeterDeltaX-GPSDeltaX) / GPSDeltaX;
//		//double error = Math.abs(GPSDeltaX - TelemeterDeltaX) / TelemeterDeltaX;
//		
//		//error*=0.5;
//		
//		//if(error>1.0)
//		//error = 1.0;
//		
//		double directTrustValue = 1.0 - error;
//		
//		if(directTrustValue<0.0)
//			directTrustValue=0.0;
//		
//		if(directTrustValue>1.0)
//			directTrustValue=1.0;
//		
//		/*if(directTrustValue<0.5){
//			System.out.println("evaluated direct trust value for " + immediateFollower.getSenderId() + " is " + directTrustValue);
//			System.out.println(" Xi = " + myPosition + " Xj = " + immediateFollower.getAbsoluteX() +  ", GPSDeltaX = " + GPSDeltaX + " , " + "TelemeterDeltaX = " + TelemeterDeltaX);
//		}*/
//		
//    	return directTrustValue;
//	}

	@Override
	public void computeTrust(Trust trust, long thisId) {
		ITijs = this.computeIndirectTrustValues(trust, thisId, Tkjs);
		//System.out.println(Tkjs.size());
		trust.setSelfTrust(this.computeSelfTrust(Tkks, Tkis));
		this.updateTrust(trust, DTijs, ITijs, trust.getTrustValue(thisId));
	}

	private Hashtable<Long,Double> computeIndirectTrustValues(Trust trust, long thisId, ArrayList<Tij> Tkjs) {
    	Hashtable<Long,Double> ITijs = new Hashtable<Long,Double>();
    	
    	
    	while(Tkjs.size()>0){
    	
    		// select first
    		long j = Tkjs.get(0).getj();
    		ArrayList<Tij> Txjs = new ArrayList<Tij>();
    		
    		Iterator<Tij> iterator = Tkjs.iterator();
    	    while (iterator.hasNext()) {
    	    	Tij tij = iterator.next();
    	    	if(tij.getj()==j){
    	    		Txjs.add(tij);
    	    		iterator.remove();
    	    	}
    	    }

    	    
    	    Tij Txj = this.computeIndirectTrustValue(trust, thisId, Txjs);
    	    if(Txj != null){
    	    	ITijs.put(Txj.getj(), Txj.getTrustValue().getValue());
    	    } else {
    	    	ITijs.put(j, TrustValue.defaultValue().getValue());
    	    }
    	    
    	}
    	
		return ITijs;
	}

	private Tij computeIndirectTrustValue(Trust trust, long thisId, ArrayList<Tij> Txjs) {
	    	
    	if(Txjs.size()>0){
	
	    	double num = 0.0;
	    	double denum = 0.0;
	    	
	    	for(Tij Tkj : Txjs){
	    		if(trust.hasTrustValue(Tkj.geti())){ 
	    			double Tik = trust.getTrustValue(Tkj.geti()).getValue();
	    			num+= Tik * Tkj.getTrustValue().getValue();
	    			denum+= Tik;
	    			
	    		
	    		} else {
	    			double Tik = TrustValue.defaultValue().getValue();
	    			num+= Tik * Tkj.getTrustValue().getValue();
	    			denum+= Tik;
	    		}
	    	}
	    	
	    	if(num<0.0 || denum<=0.0){
	    		return null;
	    	} else {
	    		double value = num/denum;

	    		
	    		long i = thisId;
	    		long j = Txjs.get(0).getj();
	    		
	    		return new Tij(i,j,new TrustValue(value));
	    	}
    	} 
    	
		return null;
	}
	 

	private TrustValue computeSelfTrust(ArrayList<Tij> Tkks, ArrayList<Tij> Tkis) {
		
		TrustValue trustValue = new TrustValue();
		
		double num = 0.0;
    	double denum = 0.0;
		
    	//System.out.println("tkks = " + Tkks.size() + " , Tkis = " + Tkis.size());
    	
		//System.out.println(Tkis.get(0).geti());
		for(Tij tkk : Tkks){
			//boolean found = false;
			//System.out.println(tkk.geti() + " " + tkk.getj());
			for(Tij tki : Tkis){
				
				if(tki.geti()==tkk.geti()){
					num+=tkk.getTrustValue().getValue() * tki.getTrustValue().getValue();
					denum+=tkk.getTrustValue().getValue();
					//found = true;
					//System.out.println(num);
				}
				
			}
			//if(!found){
			//	num+=1.0;
			//	denum+=1.0;
			//}
			
		}
		
		if(num>=0.0 && denum>0.0){
    		double value = num/denum;
    		trustValue = new TrustValue(value);
    		//if(value<0.90)
    		//System.out.println("Self trust of " + this.getId() + " = " + value);
    	}
		
		
		//trustValue = new TrustValue(TrustValue.defaultValue());
		
		return trustValue;
		
	}
	
	private void updateTrust(Trust trust, Hashtable<Long, Double> DTijs, Hashtable<Long, Double> ITijs, TrustValue selfTrustValue) {

		double Tii = selfTrustValue.getValue();
		
		ArrayList<Long> updatedIds = new ArrayList<Long>();
		
		for(Long id : DTijs.keySet()){
			if(DTijs.containsKey(id)){
				if(ITijs.containsKey(id)){
					double DTij = DTijs.get(id).doubleValue();
					double ITij = ITijs.get(id).doubleValue();
					double Tij = (Tii * DTij + ITij) / (Tii + 1);
					trust.setTrustValue(id, new TrustValue(Tij));
					updatedIds.add(id);
				} else {
					//important for initialization phase
					double DTij = DTijs.get(id).doubleValue();
					double Tij = DTij;
					trust.setTrustValue(id, new TrustValue(Tij));
					updatedIds.add(id);
				}
			}
		}
		
		for(Long id : ITijs.keySet()){
			if(ITijs.containsKey(id)){
				boolean found = false;
				for(Long idupdated : updatedIds){
					if(id==idupdated){
						found =true;
					}
				}
				
				if(!found/* && trust.hasTrustValue(id)*/){
					double Tij = ITijs.get(id).doubleValue();
					trust.setTrustValue(id, new TrustValue(Tij));
				}
			}
		}
		
	}

}
