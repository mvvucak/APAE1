package model;

public final class NorthSouthCar extends Vehicle {

	public NorthSouthCar(int size, int speed, int verticalLane, int horizontalLane, char symbol)
	{
		super(size, speed, verticalLane, horizontalLane, symbol);	
		this.currentCell = null;
	}
	
	/*
	 * Moves the car across the intersection by successively entering the next cell.
	 * North-South cars start in the first row and move down without changing their vertical lane.
	 */
	public void move() {
		//For each cell in the North-South car's vertical lane, starting from the topmost.
		for(int pos = horizontalLane; pos < this.crossing.getRows(); pos++)
		{
			//Try to enter next cell in intersection.
			crossing.getSpecificCell(pos, verticalLane).enter(this);
			try
			{
				Thread.sleep(this.speed);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//Exit last cell in intersection.
		currentCell.exit();

	}

}
