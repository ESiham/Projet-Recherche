package emotion.physique;

import java.util.ArrayList;

import org.movsim.simulator.vehicles.Vehicle;

import emotion.Emotion;


public  abstract interface EmotionManagement {
	public  ArrayList<Emotion> InitialState(); //l'etat initial de chaque conducteur
	public  Emotion ModifyStateAccordingtoDrivers(Vehicle devant, Vehicle arriere, Emotion e, ArrayList<Emotion> list);  //modification des emotions du conducteur depend des autres conducteurs
	public  Emotion DominanteEmotion(ArrayList<Emotion> listEmotion);
	public void ModifySpeedAccordingtoDominanteEmotion(Emotion e);
	//public  void ModifyBehaviours();//modifier le comportement apres emotion
	public  void ModifySpeedAccordingtoEmotion();
	public void updateState(Emotion e);
	

}
