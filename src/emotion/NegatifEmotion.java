package emotion;

public class NegatifEmotion extends Emotion{
	
	public NegatifEmotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NegatifEmotion(String name, Double intensity) {
		super(name, intensity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double updateIntensity(double rate, String name) {
		this.intensity =- (this.intensity)*(rate/100); // augmenter l'intensite d'un taux de rate%
		return this.intensity;
	}
	

}
