package emotion.physique;

import java.util.ArrayList;

import org.movsim.autogen.VehiclePrototypeConfiguration;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.simulator.vehicles.lanechange.LaneChangeModel;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.LongitudinalModelBase;

import emotion.Emotion;
import emotion.NegatifEmotion;
import emotion.PositifEmotion;
import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import maop.MaopVehicleCorrection;

public  class EmotionalVehicle extends MaopVehicleCorrection implements EmotionManagement {
	
	Emotion emotion;
	ArrayList<Emotion> listEmotion = new ArrayList<>();
	

	public EmotionalVehicle(double roadLength, double d, int laneNumber, double e, double f, Emotion emotion,
			ArrayList<Emotion> listEmotion) {
		super(roadLength, d, laneNumber, e, f);
		this.emotion = emotion;
		this.listEmotion = listEmotion;
	}
	
	public EmotionalVehicle(double roadLength, double d, int laneNumber, double e, double f) {
		super(roadLength, d, laneNumber, e, f);
		// TODO Auto-generated constructor stub
	}

	public EmotionalVehicle(String label, LongitudinalModelBase accelerationModel,
			VehiclePrototypeConfiguration configuration, LaneChangeModel laneChangeModel) {
		super(label, accelerationModel, configuration, laneChangeModel);
		// TODO Auto-generated constructor stub
	}

	public EmotionalVehicle(Vehicle vehicle) {
		super(vehicle);
		// TODO Auto-generated constructor stub
	}

	public EmotionalVehicle(MaopVehicleCorrection vehicle,ArrayList<Emotion> emotion) {
   
		
		super(vehicle);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void ModifySpeedAccordingtoEmotion() {
		for(Emotion e : listEmotion) {
			switch(e.getName()) {
			case "Anger":
				 this.modifyDesiredSpeed(+1.5);
			case "Stress":
				 this.scenarioSlowVehicles();
							
			}			
		}
	}


@Override
	public ArrayList<Emotion> InitialState(){
	Emotion e5= new Emotion("Joy",0.3);listEmotion.add(e5);
	Emotion e1= new Emotion("Anger",0.7);listEmotion.add(e1);
	Emotion e2= new Emotion("Fear",0.3);listEmotion.add(e2);
	Emotion e3= new Emotion("Sadness",0.3);listEmotion.add(e3);
	Emotion e4= new Emotion("Stress",0.3);listEmotion.add(e4);
	
		return this.setListEmotion(listEmotion);
	}

/*
	public Emotion ModifyState(Vehicle devant, Vehicle arriere, Emotion e, ArrayList<Emotion> list) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public Emotion DominanteEmotion(ArrayList<Emotion> listEmotion) {
		   Emotion emotionDomainante=null;
					ArrayList<PositifEmotion> listEmotionPositives=new ArrayList<>();
					ArrayList<NegatifEmotion> listEmotionNegatives=new ArrayList<>();
					double sommeIntensitiesNegative=0;
					double sommeIntensitiesPositive=0;
					int N=0, P=0;
					for(int i=0; i < listEmotion.size(); i++) {
						if(listEmotion.get(i) instanceof PositifEmotion) {
							P++;
							sommeIntensitiesPositive=+listEmotion.get(i).getIntensity();
							listEmotionPositives.add((PositifEmotion) listEmotion.get(i));
							
						}
						if(listEmotion.get(i) instanceof NegatifEmotion) {
							N++;
							sommeIntensitiesNegative=+listEmotion.get(i).getIntensity();
							listEmotionNegatives.add((NegatifEmotion) listEmotion.get(i));
						}
							
					}
					if(sommeIntensitiesNegative/N > sommeIntensitiesPositive/P) {
						//il faut chercher dans la liste des emotions negative l'emotion dont l'intensite est la plus grande
						for(int i=0; i<listEmotionNegatives.size(); i++)
						{
							for(int j=i ; j<listEmotionNegatives.size(); j++)
							{
								emotionDomainante= listEmotionNegatives.get(i).compareTo( listEmotionNegatives.get(j));
							}
						}
			                
						}
					else {
						for(int i=0; i<listEmotionPositives.size(); i++)
						{
							for(int j=i ; j<listEmotionPositives.size(); j++)
							{
								emotionDomainante = listEmotionPositives.get(i).compareTo( listEmotionPositives.get(j));
							}
						}
					}
					
				 
					return emotionDomainante;
	}
@Override
public Emotion ModifyStateAccordingtoDrivers(Vehicle devant, Vehicle arriere, Emotion e, ArrayList<Emotion> list) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void updateState(Emotion emotion) {
	// TODO Auto-generated method stub
	for(Emotion e:listEmotion) {
		if(e.getName()==emotion.getName()) {
			e.setIntensity(emotion.getIntensity());
		}
	}
	
}

@Override
public void ModifySpeedAccordingtoDominanteEmotion(Emotion e) {
	// TODO Auto-generated method stub
	switch(e.getName()) {
	case "Anger":
		 this.modifyDesiredSpeed(+1.5);
	case "Stress":
		 this.scenarioSlowVehicles();
					
	}	
}

public ArrayList<Emotion> getListEmotion() {
	return listEmotion;
}

public ArrayList<Emotion> setListEmotion(ArrayList<Emotion> listEmotion) {
	return this.listEmotion = listEmotion;
}





	



}
