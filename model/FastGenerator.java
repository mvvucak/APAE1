package model;

public class FastGenerator extends TrafficGenerator {
	
	public FastGenerator(int direction)
	{
		super(direction);
	}
	
	public FastGenerator(int firstLane, int lastLane, int direction)
	{
		super(firstLane, lastLane, direction);
	}

	@Override
	/**
	 * Generates a "fast" speed for a vehicle: between 50 and 100ms.
	 * @return The speed in ms.
	 */
	public int generateSpeed() {
		return rand.nextInt(50)+50;
	}

	@Override
	/**
	 * Generates a random time to wait before making the next vehicle.
	 * @return: the interval time in ms.
	 */
	public int generateIntervalTime() {
		return rand.nextInt(200)+300; 	
	}

}
