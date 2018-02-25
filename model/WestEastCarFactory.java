package model;

public class WestEastCarFactory implements VehicleFactory {
	
	public WestEastCarFactory()
	{
		
	}

	@Override
	public Vehicle createVehicle(int speed, int lane) {
		//Car size is always 1.
		int size = 1;
		//West-East cars always start in the first column.
		int verticalLane = 0;
		int horizontalLane = lane;
		char symbol = 'o';
		WestEastCar wec = new WestEastCar(size, speed, verticalLane, horizontalLane, symbol);
		return wec;
	}

}
