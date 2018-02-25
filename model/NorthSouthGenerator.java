package model;

import java.util.Random;

public class NorthSouthGenerator extends TrafficGenerator {
	
	private Random rand;
	
	public NorthSouthGenerator()
	{
		super();
		this.carMaker = new NorthSouthCarFactory();
		rand = new Random();
	}
	
	public NorthSouthGenerator(int firstLane, int lastLane)
	{
		super(firstLane, lastLane);
	}

	@Override
	public int[] getAllLanes() {
		Intersection crossing = Intersection.getInstance();
		int[] lanes = new int[2];
		lanes[0] = 0;
		lanes[1] = crossing.getCols();
		return lanes;
	}

	@Override
	public int generateSpeed() {
		// TODO Auto-generated method stub
		return 700;
	}

	@Override
	public int generateIntervalTime() {
		// TODO Auto-generated method stub
		return 500;
	}

	@Override
	public int chooseLane() {
		int lane = rand.nextInt(lastLane);
		return lane;
	}

}
