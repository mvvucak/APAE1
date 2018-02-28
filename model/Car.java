package model;

public class Car extends Vehicle {
	
	
	public Car(int speed, Navigator nav)
	{
		//A car is always of size 1.
		super(1, speed, nav);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
