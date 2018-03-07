package model;

public class CarFactory {
	
	private NavigatorFactory navFactory;
	
	
	public CarFactory(int direction)
	{
		//Instantiate navigator factory according to direction provided.
		switch(direction)
		{
			case TrafficGenerator.EAST_WEST: navFactory = new WestLaneNavigatorFactory(); break;
			case TrafficGenerator.WEST_EAST: navFactory = new EastLaneNavigatorFactory(); break;
			case TrafficGenerator.NORTH_SOUTH: navFactory = new SouthLaneNavigatorFactory(); break;
			case TrafficGenerator.SOUTH_NORTH: navFactory = new NorthLaneNavigatorFactory(); break;
		}
	}
	
	/**
	 * Creates a car and fits it with the corresponding navigator object, which tells the car where to go.
	 * @param: speed: The time in ms that the car will spend in each cell.
	 * @param: lane: Which lane the car will travel in.
	 * @return: The complete car, ready to traverse an intersection.
	 */
	public Vehicle createCar(int speed, int lane)
	{
		//Car size is always 1: it never takes up more than 1 cell in the intersection.
		int size = 1;
		//Instantiate navigator and the car that will use it.
		Navigator nav = navFactory.createNavigator(lane);
		Vehicle car = new Vehicle(size, speed, nav);
		return car;
	}

}
