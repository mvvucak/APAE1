package model;

public class WestEastCarFactory implements VehicleFactory {
	
	public WestEastCarFactory()
	{
		
	}

	@Override
	public Vehicle createVehicle(int speed, int startingPosition) {
		//Car size is always 1.
		int size = 1;
		char symbol = 'o';
		WestEastCar wec = new WestEastCar(size, speed, startingPosition, symbol);
		return wec;
	}

}
