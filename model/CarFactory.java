package model;

public class CarFactory {
	
	private NavigatorFactory navFactory;
	
	
	public CarFactory(NavigatorFactory navFactory)
	{
		this.navFactory = navFactory;
	}
	
	/**
	 * Creates a car and fits it with the corresponding navigator object, which tells the car where to go.
	 * @param: speed: The time in ms that the car will spend in each cell.
	 * @return: The complete car, ready to traverse an intersection.
	 */
	public Vehicle createCar(int speed)
	{
		//Car size is always 1: it never takes up more than 1 cell in the intersection.
		int size = 1;
		//Instantiate navigator and the car that will use it.
		Navigator nav = navFactory.createNavigator();
		Vehicle car = new Vehicle(size, speed, nav);
		return car;
	}

}
