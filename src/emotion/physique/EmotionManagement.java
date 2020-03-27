package emotion.physique;

import java.util.ArrayList;

import org.movsim.simulator.vehicles.Vehicle;

import emotion.Emotion;


public  interface EmotionManagement {
	public  void InitialState(); //l'etat initial de chaque conducteur
	public  Emotion ModifyStateAccordingtoDrivers(Vehicle devant, Vehicle arriere, Emotion e, ArrayList<Emotion> list);  //modification des emotions du conducteur depend des autres conducteurs
	public  Emotion DominanteEmotion();
	public void ModifySpeedAccordingtoDominanteEmotion();
	//public  void ModifyBehaviours();//modifier le comportement apres emotion
	public  void ModifySpeedAccordingtoEmotion();
	public void updateState(Emotion e);
	

}
