package model;

public class Vehicle implements Runnable {
	
	private int size, speed;
	private long startTime, endTime;
	private char symbol;
	private Navigator nav;
	private Cell currentCell;
	private VehicleObserver parentGenerator; 
	private static boolean simulationFinished = false;
	
	public Vehicle(int size, int speed, Navigator nav)
	{
		this.size = size;
		this.speed = speed;
		this.nav = nav;
		this.symbol = nav.getMarker();
	}
	
	//Moves vehicle to the next cell specified by the navigator.
	public void move()
	{
		startTime = System.currentTimeMillis();
		while(!nav.isOnLastCell() && !Vehicle.simulationFinished)
		{
			Cell next = nav.getNextCell();
			next.enter(this);
			//nav.getNextCell().enter(this);
			try
			{
				Thread.sleep(this.speed);
			}
			catch(InterruptedException e){
				
			}
		}
		//If simulation is running, reached this block by traversing entire intersection.
		if(!Vehicle.simulationFinished) terminate();
		//Otherwise, reached this block because simulation ended. Did not traverse intersection.
	}
	
	public void terminate()
	{
		this.leaveCell();
		this.endTime = System.currentTimeMillis();
		long travelTime = endTime - startTime;
		notifyParentGenerator(travelTime);
	}
		

	
	public void notifyParentGenerator(long travelTime)
	{
		parentGenerator.update(travelTime);
	}
	
	public static void stopMovement()
	{
		Vehicle.simulationFinished = true;
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
	
	public void setObserver(VehicleObserver obv)
	{
		this.parentGenerator = obv;
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
		this.symbol = nav.getMarker();
	}
	
	public Navigator getNavigator()
	{
		return this.nav;
	}
	
	public long getTravelTime()
	{
		return endTime - startTime;
	}
	
	
}
