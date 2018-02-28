package model;

public class WestLaneNavigator extends SingleLaneNavigator {
	
	public WestLaneNavigator(int laneIndex)
	{
		this(laneIndex, 0, 'c');
	}
	
	public WestLaneNavigator(int laneIndex, int nextCellPosition, char marker)
	{
		super(laneIndex, nextCellPosition, marker);
	}

	@Override
	public Cell[] findLane(int laneIndex) {
		Intersection crossing = Intersection.getInstance();
		
		//Retrieve the cells to be traversed in west-east order.
		Cell[] lane = crossing.getHorizontalLane(laneIndex);
		
		//Reverse the lane so that cells are in east-west order.
		Cell temp;
		
		//Iterate until mid-point of lane.
		for(int i=0; i<lane.length/2; i++)
		{
			//Swap cells on opposite sides of the lane.
			temp = lane[i];
			lane[i] = lane[lane.length-i-1];
			lane[lane.length-i-1] = temp;
		}
		return lane;
	}

}
