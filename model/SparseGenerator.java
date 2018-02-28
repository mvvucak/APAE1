package model;

import java.util.Random;

public class SparseGenerator extends TrafficGenerator {
	
	private Random rand;
	
	public SparseGenerator(int direction)
	{
		super(direction);
		this.rand = new Random();
	}
	
	public SparseGenerator(int firstLane, int lastLane, int direction)
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
		return 1500;
	}

	@Override
	public int chooseLane() {
		int lane = rand.nextInt(lastLane);
		return lane;
	}

}
