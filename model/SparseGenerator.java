package model;



public class SparseGenerator extends TrafficGenerator {
	
	
	
	public SparseGenerator(int direction)
	{
		super(direction);
	}
	
	public SparseGenerator(int firstLane, int lastLane, int direction)
	{
		super(firstLane, lastLane, direction);
	}

	@Override
	/**
	 * Generates a random speed for a vehicle between 300 and 500ms.
	 * @return The speed in ms.
	 */
	public int generateSpeed() {
		return rand.nextInt(200)+300;
	}

	@Override
	/**
	 * Generates a random time to wait before making the next vehicle.
	 * @return: the interval time in ms.
	 */
	public int generateIntervalTime() {
		return 1500;
	}
}
