package model;

public abstract class TrafficGenerator implements Runnable {
	
	protected int firstLane, lastLane;
	protected VehicleFactory carMaker;
	
	public TrafficGenerator()
	{
		this(-1, -1);
	}
	
	public TrafficGenerator(int firstLane, int lastLane)
	{
		if(firstLane<0 && lastLane<0)
		{
			int[] lanes = getAllLanes();
			firstLane = lanes[0];
			lastLane = lanes[1];
		}
		this.firstLane = firstLane;
		this.lastLane = lastLane;
	}
	
	public void run()
	{
		generateVehicles();
	}
	
	public abstract int[] getAllLanes();

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