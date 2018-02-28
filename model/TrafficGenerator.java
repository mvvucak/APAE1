package model;

public abstract class TrafficGenerator implements Runnable {
	
	//Direction Constants
	public static final int WEST_EAST = 0;
	public static final int NORTH_SOUTH = 1;
	public static final int EAST_WEST = 2;
	public static final int SOUTH_NORTH = 3;
	
	protected int firstLane, lastLane;
	protected VehicleFactory carMaker;
	protected int direction;
	
	public TrafficGenerator(int direction)
	{
		this(-1, -1, direction);
	}
	
	public TrafficGenerator(int firstLane, int lastLane, int direction)
	{
		this.direction = direction;
		if(firstLane < 0 && lastLane < 0)
		{
			int[] lanes = getAllLanes();
			firstLane = lanes[0];
			lastLane = lanes[1];
		}
		this.firstLane = firstLane;
		this.lastLane = lastLane;
		this.carMaker = createFactory();
	}
	
	public void run()
	{
		generateVehicles();
	}
	
	public int[] getAllLanes()
	{
		Intersection crossing = Intersection.getInstance();
		int[] lanes = new int[2];
		lanes[0] = 0;
		if(direction == WEST_EAST || direction == EAST_WEST)
		{
			lanes[1] = crossing.getRows();
		}
		else
		{
			lanes[1] = crossing.getCols();
		}
		
		return lanes;
	}
	
	public VehicleFactory createFactory()
	{
		VehicleFactory carMaker = null;
		
		if(direction == WEST_EAST)
		{
			carMaker = new WestEastCarFactory();
		}
		else if(direction == EAST_WEST)
		{
			//Make East To West Factory
		}
		else if(direction == NORTH_SOUTH)
		{
			carMaker = new NorthSouthCarFactory();
		}
		else
		{
			//Make South To North Factory
		}
		
		return carMaker;
	}

	public abstract int generateSpeed();

	public abstract int generateIntervalTime();
	
	public abstract int chooseLane();
	
	public void generateVehicles()
	{
		int interval = generateIntervalTime();
		for(;;)
		{
			int speed = generateSpeed();
			int lane = chooseLane();
			Vehicle v = carMaker.createVehicle(speed, lane);
			Thread t = new Thread(v);
			t.start();
			try
			{
				Thread.sleep(interval);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
	}
}