package model;

import java.util.Random;

public class WestEastGenerator extends TrafficGenerator {
	
	private Random rand;
	
	public WestEastGenerator()
	{
		super();
		this.carMaker = new WestEastCarFactory();
		rand = new Random();
	}
	
	public WestEastGenerator(int firstLane, int lastLane)
	{
		super(firstLane, lastLane);
	}

	@Override
	public int[] getAllLanes() {
		Intersection crossing = Intersection.getInstance();
		int[] lanes = new int[2];
		lanes[0] = 0;
		lanes[1] = crossing.getRows();
		return lanes;
	}

	@Override
	public int generateSpeed() {
		// TODO Auto-generated method stub
		return rand.nextInt(400)+200;
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
