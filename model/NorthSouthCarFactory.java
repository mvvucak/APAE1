package model;

public class NorthSouthCarFactory implements VehicleFactory {

	@Override
	public Vehicle createVehicle(int speed, int startingPosition) {
		//Car size is always 1.
		int size = 1;
		char symbol = 'x';
		NorthSouthCar nsc = new NorthSouthCar(size, speed, startingPosition, symbol);
		return nsc;
	}

}
