package model;

public class EastLaneNavigator extends SingleLaneNavigator {
	
	public EastLaneNavigator(int laneIndex)
	{
		this(laneIndex, 0, '>');
	}
	
	public EastLaneNavigator(int laneIndex, int nextCellPosition, char marker)
	{
		super(laneIndex, nextCellPosition, marker);
	}

	@Override
	public Cell[] findLane(int laneIndex) {
		Intersection crossing = Intersection.getInstance();
		
		//Retrieve the cells to be traversed in west-east order.
		Cell[] lane = crossing.getHorizontalLane(laneIndex);
		
		
		return lane;
	}

}
