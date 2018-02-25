package model;

public class NorthSouthCarFactory implements VehicleFactory {

	@Override
	public Vehicle createVehicle(int speed, int lane) {
		//Car size is always 1.
		int size = 1;
		int verticalLane = lane;
		//North-South cars always start in the first row.
		int horizontalLane = 0;
		char symbol = 'x';
		NorthSouthCar nsc = new NorthSouthCar(size, speed, verticalLane, horizontalLane, symbol);
		return nsc;
	}

}
