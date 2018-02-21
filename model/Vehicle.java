package model;

public abstract class Vehicle implements Runnable {
	
	protected int size,speed, startingPosition;
	protected char symbol;
	protected Intersection crossing;
	
	public Vehicle(int size, int speed, int startingPosition, char symbol)
	{
		this.size = size;
		this.speed = speed;
		this.startingPosition = startingPosition;
		this.symbol = symbol;
		this.crossing = Intersection.getInstance();
	}
	
	//Moves vehicle to the next cell in the intersection.
	public abstract void move();
	
	public void run()
	{
		this.move();
	}
	
	public char getSymbol()
	{
		return this.symbol;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}

	public int getSize()
	{
		return this.size;
	}
}
