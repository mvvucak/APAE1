package model;

public abstract class Vehicle implements Runnable {
	
	protected int size,speed, verticalLane, horizontalLane;
	protected char symbol;
	protected Intersection crossing;
	protected Cell currentCell;
	
	public Vehicle(int size, int speed, int verticalLane, int horizontalLane, char symbol)
	{
		this.size = size;
		this.speed = speed;
		this.verticalLane = verticalLane;
		this.horizontalLane = horizontalLane;
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
	
	public void setCurrentCell(Cell currentCell)
	{
		this.currentCell = currentCell;
	}
	
	public Cell getCurrentCell()
	{
		return this.currentCell;
	}
}
