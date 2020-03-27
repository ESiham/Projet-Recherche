package fr.ifsttar.licit.simulator.agents.trust.representation.experience;

import java.util.LinkedList;

import fr.ifsttar.licit.simulator.agents.trust.representation.TrustValue;

public class ExperienceTrustValue extends TrustValue {

	public static double MEMORY_SIZE = 6000;
	
	private LinkedList<Experience> experiences = new LinkedList<Experience>();
	
	@Override
	public double getValue() {
		//TODO: first compute the weighted mean into "value", then return "value
		
		double sum = 0;
		double num = 0;
		
		final double lambda = -60 / Math.log10(0.5);
		
		for(Experience e : this.experiences){
			
			double w = Math.exp(-e.getDate() / lambda);
			sum+=e.getValue()*w;
			num+=w;
		}
		
		if(num==0){
			this.value = 1.0;
		} else {
			this.value = sum/num;
		}
		
		//System.out.println(value);
		
		return value;
	}
	
	public ExperienceTrustValue(ExperienceTrustValue trustValue) {
		super(trustValue.value);
		for(Experience e : trustValue.experiences){
			this.addExperience(e.clone());
		}
	}
	
	private void addExperience(Experience experience) {
		
	}
	
	public void addExperience(double value, double date){
		Experience exp = new Experience(value, date);
		this.experiences.add(exp);
		while(experiences.size()>MEMORY_SIZE){
			this.experiences.removeFirst();
		}
	}

	public ExperienceTrustValue(double value, double date) {
		this.addExperience(value,date);
	}

	public class Experience {
		private double value;
		private double date;
		
		public Experience(double value, double date){
			this.value=value;
			this.date=date;
		}
		
		public double getValue(){
			return value;
		}
		
		public double getDate(){
			return date;
		}
		
		@Override
		public Experience clone(){
			return new Experience(this.value, this.date);
		}
	}
}
