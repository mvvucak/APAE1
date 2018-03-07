package model;

public class GaussianGenerator extends TrafficGenerator {
	
	private int meanSpeed, speedStDev;
	private int meanInterval, intervalStDev;
	
	public GaussianGenerator(int direction)
	{
		super(direction);
	}
	
	public GaussianGenerator(int firstLane, int lastLane, int direction)
	{
		super(firstLane, lastLane, direction);
	}
	
	private void instantiateDefaultStats()
	{
		this.meanSpeed = 300;
		this.speedStDev = 100;
		
		this.meanInterval = 400;
		this.intervalStDev = 150;
	}

	@Override
	/**
	 * Generates a speed for a vehicle from a normal distribution
	 * With mean of 300ms and st. dev of 100ms.
	 * @return The speed in ms.
	 */
	public int generateSpeed() {
		return (int) rand.nextGaussian()*speedStDev+meanSpeed;
	}

	@Override
	/**
	 * Generates a random time to wait before making the next vehicle
	 * from a normal distribution with mean of 300ms and st. dev of 100ms.
	 * @return: the interval time in ms.
	 */
	public int generateIntervalTime() {
		return (int) rand.nextGaussian()*intervalStDev+meanInterval;
	}

	public int getMeanSpeed() {
		return meanSpeed;
	}

	public void setMeanSpeed(int meanSpeed) {
		this.meanSpeed = meanSpeed;
	}

	public int getSpeedStDev() {
		return speedStDev;
	}

	public void setSpeedStDev(int speedStDev) {
		this.speedStDev = speedStDev;
	}

	public int getMeanInterval() {
		return meanInterval;
	}

	public void setMeanInterval(int meanInterval) {
		this.meanInterval = meanInterval;
	}

	public int getIntervalStDev() {
		return intervalStDev;
	}

	public void setIntervalStDev(int intervalStDev) {
		this.intervalStDev = intervalStDev;
	}

}
