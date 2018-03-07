package model;

import java.util.Random;
import java.util.ArrayList;

public abstract class TrafficGenerator implements Runnable, VehicleObserver {
	
	//Direction Constants
	public static final int WEST_EAST = 0;
	public static final int NORTH_SOUTH = 1;
	public static final int EAST_WEST = 2;
	public static final int SOUTH_NORTH = 3;
	protected static int generatorCounter = 1;
	
	protected int firstLane, lastLane, vehiclesMade, direction, id;
	protected CarFactory carMaker;
	protected Random rand;
	protected ArrayList<Long> travelTimes;
	protected volatile boolean isFinished;
	
	/**
	 * Construct a traffic generator for all lanes in given direction.
	 * @param direction: A TrafficGenerator constant defining the direction vehicles travel in.
	 */
	public TrafficGenerator(int direction)
	{
		this(-1, -1, direction);
	}
	
	/**
	 * Construct a traffic generator which will create and send cars down specified lanes
	 * in the specified direction.
	 * @param firstLane: Index of first lane to generate vehicles for (inclusive)
	 * @param lastLane: Index of last lane to generate vehicles for (exclusive)
	 * @param direction: A TrafficGenerator constant defining the direction vehicles travel in.
	 */
	public TrafficGenerator(int firstLane, int lastLane, int direction)
	{
		this.id = generatorCounter++;
		this.direction = direction;
		//If no lanes specified, get all lanes in specified direction.
		if(firstLane < 0 && lastLane < 0)
		{
			int[] lanes = getAllLanes();
			firstLane = lanes[0];
			lastLane = lanes[1];
		}
		this.firstLane = firstLane;
		this.lastLane = lastLane;
		
		this.travelTimes = new ArrayList<Long>();
		this.carMaker = new CarFactory(this.direction);
		
		this.rand = new Random();
		this.isFinished = false;
	}
	
	public void run()
	{
		generateVehicles();
	}
	
	/**
	 * Retrieves indices of all lanes heading in the constructor-specified direction.
	 * First index is inclusive, second index is exclusive.
	 * @return A 2-element array containing the lane indices.
	 */
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
	
	/**
	 * Generate a speed for newly created vehicles.
	 * @return The time in ms a vehicle will spend in a cell.
	 */
	public abstract int generateSpeed();

	/**
	 * Generate time between making new vehicles.
	 * @return The time in ms between making one vehicle and the next.
	 */
	public abstract int generateIntervalTime();
	
	/**
	 * Randomly chooses a lane between firstLane(inclusive) and lastLane (exclusive).
	 * @return the lane index.
	 */
	public int chooseLane()
	{
		int lane = rand.nextInt(lastLane-firstLane)+firstLane;
		return lane;
	}
	
	/**
	 * Create vehicles and send them down the specified range of lanes.
	 * Runs until told to stop (change in isFinished boolean).
	 */
	public void generateVehicles()
	{
		while(!isFinished)
		{
			int speed = generateSpeed();
			int lane = chooseLane();
			
			Vehicle v = carMaker.createCar(speed, lane);
			v.setObserver(this);
			vehiclesMade++;
			
			Thread t = new Thread(v);
			t.start();
			
			try
			{
				Thread.sleep(generateIntervalTime());
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
	}
	
	/**
	 * Changes the finished flag to break the for loop in generateVehicles().
	 */
	public void finish()
	{
		this.isFinished = true;
	}
	
	/**
	 * Adds the provided travel time to the list of completed travel times.
	 * Called by a Vehicle object when it finishes traversing the intersection.
	 * @param travelTime: The total time taken to traverse the intersection by the calling vehicle.
	 */
	public void update(long travelTime)
	{
		this.travelTimes.add(travelTime);
	}
	
	public String getName()
	{
		String name = "Generator " + this.id + ": ";
		switch(this.direction)
		{
		case TrafficGenerator.EAST_WEST: name = name + "East to West"; break;
		case TrafficGenerator.WEST_EAST: name = name + "West to East"; break;
		case TrafficGenerator.NORTH_SOUTH: name = name + "North to South"; break;
		case TrafficGenerator.SOUTH_NORTH: name = name + "South to North"; break;
		}
		return name;
	}

	public int getVehiclesMade() {
		return vehiclesMade;
	}
	
	public int getFirstLane() {
		return firstLane;
	}

	public int getLastLane() {
		return lastLane;
	}
	
	/**
	 * @return travelTimes: Travel times for vehicles in array form.
	 */
	public Long[] getTravelTimes()
	{
		Long[] travelTimes = new Long[1];
		travelTimes = this.travelTimes.toArray(travelTimes);
		return travelTimes;
	}
}