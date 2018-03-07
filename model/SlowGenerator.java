package model;



public class SlowGenerator extends TrafficGenerator {
	

	public SlowGenerator(int direction)
	{
		super(direction);
	}
	
	public SlowGenerator(int firstLane, int lastLane, int direction)
	{
		super(firstLane, lastLane, direction);
	}

	@Override
	/**
	 * Generates a "slow" speed for a vehicle: between 1 and 3 seconds.
	 * @return The speed in ms.
	 */
	public int generateSpeed() {
		return rand.nextInt(1000)+2000;
	}

	@Override
	public int generateIntervalTime() {
		// TODO Auto-generated method stub
		return 400;
	}

}
