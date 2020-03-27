package emotion;

public class Emotion {
	
		protected static String name;
		protected  double intensity;
		private  double threshold;
		 public Emotion() {
			 
		 }
		public Emotion(String name,  Double intensity) {
			this.name = name;
			
			this.intensity = intensity;
		}

		public String getName() {
			return name;
		}


		public Double getIntensity() {
			return intensity;
		}

		public Double getThreshold() {
			return threshold;
		}


		public void setIntensity(Double intensity) {
			this.intensity = intensity;
		}
		public double updateIntensity(double rate, String name) {
			
			return 0;
	} 
		public Emotion compareTo(Emotion e) {
			if (this.getIntensity() > e.getIntensity())
				return this;
			else
				return e;
		}
	

	}


