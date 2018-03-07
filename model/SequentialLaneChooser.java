package model;

public class SequentialLaneChooser extends LaneChooser {
	
	//Counter to keep track of the next lane to be returned.
	private int pos;
	
	public SequentialLaneChooser() {
		super();
		pos = 0;
	}
	
	public SequentialLaneChooser(int[] laneIndices) {
		super(laneIndices);
		this.pos = 0;
	}
	
	public void setPos(int pos)
	{
		this.pos = pos;
	}
	

	@Override
	/**
	 * Choose the next lane out of the stored lanes and increment the counter.
	 * If none are left, start from the first one.
	 * @return: The index of either a horizontal or vertical lane in Intersection.
	 */
	public int chooseLane() {
		if(pos >= this.laneIndices.length)
		{
			pos = 0;
		}
		return this.laneIndices[pos++];
	}

}
