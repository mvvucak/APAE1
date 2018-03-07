package model;

public class UniformGenerator extends TrafficGenerator {
	
	private int minSpeed, maxSpeed;
	private int minInterval, maxInterval;
	
	public UniformGenerator(CarFactory carMaker)
	{
		super(carMaker);
		instantiateDefaultRanges();
	}
	
	private void instantiateDefaultRanges()
	{
		//Instantiate speed and interval ranges with default values.
		this.minSpeed = 300;
		this.maxSpeed = 500;
		
		this.minInterval = 300;
		this.maxInterval = 500;
	}

	@Override
	/**
	 * Generates a random speed for a vehicle between 300 and 500ms.
	 * @return The speed in ms.
	 */
	public int generateSpeed() {
		return rand.nextInt(maxSpeed-minSpeed)+minSpeed;
	}

	@Override
	/**
	 * Generates a random time to wait before making the next vehicle.
	 * @return: the interval time in ms.
	 */
	public int generateIntervalTime() {
		return rand.nextInt(maxInterval-minInterval)+minInterval; 	
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(int minSpeed) {
		this.minSpeed = minSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMinInterval() {
		return minInterval;
	}

	public void setMinInterval(int minInterval) {
		this.minInterval = minInterval;
	}

	public int getMaxInterval() {
		return maxInterval;
	}

	public void setMaxInterval(int maxInterval) {
		this.maxInterval = maxInterval;
	}
}
