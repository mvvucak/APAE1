package model;



public class SlowGenerator extends TrafficGenerator {
	
	public SlowGenerator(CarFactory carMaker)
	{
		super(carMaker);
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
