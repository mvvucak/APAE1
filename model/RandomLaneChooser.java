package model;

import java.util.Random;

public class RandomLaneChooser extends LaneChooser {
	
	Random rand;
	
	public RandomLaneChooser()
	{
		super();
		rand = new Random();
	}
	
	public RandomLaneChooser(int[] laneIndices)
	{
		super(laneIndices);
		rand = new Random();
	}

	@Override
	/**
	 * Randomly choose one of the stored lanes.
	 * @return: The index of either a horizontal or vertical lane in Intersection.
	 */
	public int chooseLane() 
	{
		int arrayIndex = rand.nextInt(this.laneIndices.length);
		return this.laneIndices[arrayIndex];
	}

}
