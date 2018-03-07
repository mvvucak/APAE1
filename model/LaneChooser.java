package model;

public abstract class LaneChooser {
	
	protected int[] laneIndices;
	
	public LaneChooser()
	{
		this(new int[] {});
	}
	
	public LaneChooser(int[] laneIndices)
	{
		if(laneIndices.length==0)
		{
			Intersection crossing = Intersection.getInstance();
			laneIndices = crossing.getRowIndices();
		}
		this.laneIndices = laneIndices;
	}

	public abstract int chooseLane();
}
