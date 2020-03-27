package aspects;

import java.util.ArrayList;

import org.movsim.simulator.vehicles.Vehicle;

import emotion.Emotion;
import emotion.NegatifEmotion;
import emotion.PositifEmotion;
import emotion.physique.EmotionManagement;
import emotion.physique.EmotionalVehicle;
import maop.MaopVehicle;
import maop.MaopVehicleCorrection;




public aspect FirstAspect  {
  
	
	pointcut main():execution(public void maop.MaopVehicleCorrection.makeDecision(double, long)) && this(maop.MaopVehicleCorrection);
	
	before(): main(){
		System.out.println("cela est avant la methode makeDecision");

	     MaopVehicleCorrection  mv =(MaopVehicleCorrection) thisJoinPoint.getThis(); 
	     //Emotion emotion = new Emotion("Anger",0.5);
	     //EmotionalVehicle emotional = new EmotionalVehicle(mv, emotion);
	   //  emotional.InitialState(emotion);
	    // emotional.setSpeed(90);
	     
		System.out.println("Vehicle: "+mv);
	}
	after():main(){
		System.out.println("cela est apres la methode makeDecision");

	     MaopVehicleCorrection  mv =(MaopVehicleCorrection) thisJoinPoint.getThis(); 
	   
	     EmotionalVehicle emotional = new EmotionalVehicle(mv);// declarer la partie physique
	    // emotional.InitialState();// ajouter la partie emotionnelle
	     
	    // emotional.ModifySpeedAccordingtoDominanteEmotion(emotional.DominanteEmotion(emotional.getListEmotion()));
	   
	     System.out.println("EmotionalVehicle: "+emotional.InitialState()+ "taille de la liste:"+emotional.getListEmotion().size());
	   
	     
	     for(int i=0;i<emotional.getListEmotion().size();i++) {
	    	 System.out.println(emotional.getListEmotion().get(i).getName());
	     }
		
	}
	



	

	

	
}
