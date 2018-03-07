package model;

public abstract class SingleLaneNavigator extends Navigator {
	
	protected Cell[] lane;
	protected int laneIndex, nextCellPosition;
	
	public SingleLaneNavigator(int laneIndex, char marker)
	{
		this(laneIndex, 0, marker);
	}
	
	public SingleLaneNavigator(int laneIndex, int nextCellPosition, char marker)
	{
		super(marker);
		this.nextCellPosition = nextCellPosition;
		this.lane = findLane(laneIndex);
	}
	
	public Cell getNextCell()
	{
		Cell nextCell = lane[nextCellPosition++];
		return nextCell;
	}
	
	public boolean isOnLastCell()
	{
		if(this.nextCellPosition >= this.lane.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public abstract Cell[] findLane(int laneIndex);

}
