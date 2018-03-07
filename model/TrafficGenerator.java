package model;

import java.util.Random;
import java.util.ArrayList;

public abstract class TrafficGenerator implements Runnable, VehicleObserver {
	
	protected static int generatorCounter = 1;
	
	protected int vehiclesMade, id;
	protected CarFactory carMaker;
	protected Random rand;
	protected ArrayList<Long> travelTimes;
	protected volatile boolean isFinished;
	
	/**
	 * Construct a traffic generator for all lanes in given direction.
	 * @param direction: A TrafficGenerator constant defining the direction vehicles travel in.
	
	public TrafficGenerator()
	{
		this(null);
	}
	 */
	
	/**
	 * Construct a traffic generator which will create and send cars down specified lanes
	 * in the specified direction.
	 * @param firstLane: Index of first lane to generate vehicles for (inclusive)
	 * @param lastLane: Index of last lane to generate vehicles for (exclusive)
	 * @param direction: A TrafficGenerator constant defining the direction vehicles travel in.
	 */
	public TrafficGenerator(CarFactory carMaker)
	{
		this.id = generatorCounter++;
		
		this.travelTimes = new ArrayList<Long>();
		this.carMaker = carMaker;
		
		this.rand = new Random();
		this.isFinished = false;
	}
	
	public void run()
	{
		generateVehicles();
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
	 * Create vehicles and send them down the specified range of lanes.
	 * Runs until told to stop (change in isFinished boolean).
	 */
	public void generateVehicles()
	{
		while(!isFinished)
		{
			int speed = generateSpeed();
			Vehicle v = carMaker.createCar(speed);
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
		return name;
	}

	public int getVehiclesMade() {
		return vehiclesMade;
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