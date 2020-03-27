package maop;

import java.awt.Color;

import org.movsim.autogen.VehiclePrototypeConfiguration;
import org.movsim.simulator.vehicles.lanechange.LaneChangeModel;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.LongitudinalModelBase;

public class Truck extends MaopVehicle{

	public Truck(double roadLength, double d, int laneNumber,
			double e, double f) {
		super(roadLength, d, laneNumber, e, f);
		// TODO Auto-generated constructor stub
	}

	public Truck(String label,
			LongitudinalModelBase accelerationModel,
			VehiclePrototypeConfiguration configuration,
			LaneChangeModel laneChangeModel) {
		super(label, accelerationModel, configuration,laneChangeModel);
		System.out.println("Mon super Vehicle");
		setColorObject(Color.black);
	}
	
	
	@Override
	public void makeDecision(double simulationTime, long iterationCount) {
		switch (roadSegmentId()){
		case 1 : this.setColorObject(Color.BLUE); 
				if (this.lane() == 2) 
					modifiedDesiredLane(BehaviorEnum.rightToleft);
				break;	
		case 2 : this.setColorObject(Color.RED);break;
		case 3 : this.setColorObject(Color.GREEN);break;
		case 4 : this.setColorObject(Color.BLACK);break;
		case 5 : this.setColorObject(Color.YELLOW);break;
		}
	}

	
	

}
