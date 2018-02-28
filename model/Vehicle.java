package model;

public abstract class Vehicle implements Runnable {
	
	protected int size, speed;
	protected char symbol;
	protected Navigator nav;
	protected Cell currentCell;
	
	public Vehicle(int size, int speed, Navigator nav)
	{
		this.size = size;
		this.speed = speed;
		this.nav = nav;
		this.symbol = nav.getMarker();
	}
	
	//Moves vehicle to the next cell in the intersection.
	public void move()
	{
		while(!nav.isOnLastCell())
		{
			nav.getNextCell().enter(this);
		}
		this.currentCell.exit();
	}

	public void leaveCell()
	{
		this.currentCell.exit();
	}
	
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
	
	public void setNavigator(Navigator nav)
	{
		this.nav = nav;
	}
	
	public Navigator getNavigator()
	{
		return this.nav;
	}
}
