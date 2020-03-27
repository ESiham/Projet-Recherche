package fr.ifsttar.licit.simulator.util.units;

public enum Unit implements Describable{

	MetersPerSecond{
		@Override
		public String getFullDescription() {
			return "Meters per second";
		}
	
		@Override
		public String getAbbreviation() {
			return "m/s";
		}
	
		@Override
		public String getMathScript() {
			return "m.s^-1";
		}
	},
	
	KilometersPerHour{
		@Override
		public String getFullDescription() {
			return "Kilometers Per Hour";
		}
	
		@Override
		public String getAbbreviation() {
			return "km/h";
		}
	
		@Override
		public String getMathScript() {
			return "km.h^-1";
		}
	},
	
	Second{
		@Override
		public String getFullDescription() {
			return "Second(s)";
		}
	
		@Override
		public String getAbbreviation() {
			return "s";
		}
	
		@Override
		public String getMathScript() {
			return "s";
		}
	},
	
	Meters{
		@Override
		public String getFullDescription() {
			return "Meter(s)";
		}
	
		@Override
		public String getAbbreviation() {
			return "m";
		}
	
		@Override
		public String getMathScript() {
			return "m";
		}
	},
	
	Kilometers{
		@Override
		public String getFullDescription() {
			return "Kilometer(s)";
		}
	
		@Override
		public String getAbbreviation() {
			return "km";
		}
	
		@Override
		public String getMathScript() {
			return "km";
		}
	},
	
	Probability{
		@Override
		public String getFullDescription() {
			return "";
		}
	
		@Override
		public String getAbbreviation() {
			return "";
		}
	
		@Override
		public String getMathScript() {
			return "";
		}
	},
	
	Unknown{
		@Override
		public String getFullDescription() {
			return "Unknown";
		}
	
		@Override
		public String getAbbreviation() {
			return "???";
		}
	
		@Override
		public String getMathScript() {
			return "???";
		}
	};
	

	public static double convertValueFromTo(double value, Unit unitFrom, Unit unitTo){
		
		double result = value;
		
		if(unitFrom == Unit.MetersPerSecond){
			if(unitTo == Unit.KilometersPerHour){
				result*=3.6d;
			}
		}
		
		if(unitFrom == Unit.KilometersPerHour){
			if(unitTo == Unit.MetersPerSecond){
				result/=3.6d;
			}
		}
		
		return result;
	}
	
}
