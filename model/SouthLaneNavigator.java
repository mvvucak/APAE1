package model;

public class SouthLaneNavigator extends SingleLaneNavigator {

	public SouthLaneNavigator(int laneIndex)
	{
		this(laneIndex, 0, '$');
	}
	
	public SouthLaneNavigator(int laneIndex, int nextCellPosition, char marker)
	{
		super(laneIndex, nextCellPosition, marker);
	}
	
	@Override
	public Cell[] findLane(int laneIndex) {
		
		Intersection crossing = Intersection.getInstance();
		
		//Retrieve the cells to be traversed in north-south order.
		Cell[] lane = crossing.getVerticalLane(laneIndex);
		
		return lane;
	}

}
