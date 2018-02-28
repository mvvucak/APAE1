package model;

import java.util.Random;

public class BasicGenerator extends TrafficGenerator {
	
	private Random rand;
	
	public BasicGenerator(int direction)
	{
		super(direction);
		this.rand = new Random();
	}
	
	public BasicGenerator(int firstLane, int lastLane, int direction)
	{
		super(firstLane, lastLane, direction);
	}

	@Override
	public int generateSpeed() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public int generateIntervalTime() {
		// TODO Auto-generated method stub
		return 400;
	}

	@Override
	public int chooseLane() {
		int lane = rand.nextInt(lastLane);
		return lane;
	}

}
