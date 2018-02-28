package model;

import java.util.Random;

public class SlowGenerator extends TrafficGenerator {
	
	private Random rand;
	
	public SlowGenerator(int direction)
	{
		super(direction);
		this.rand = new Random();
	}
	
	public SlowGenerator(int firstLane, int lastLane, int direction)
	{
		super(firstLane, lastLane, direction);
	}

	@Override
	public int generateSpeed() {
		// TODO Auto-generated method stub
		return 3000;
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
