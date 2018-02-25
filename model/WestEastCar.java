package model;

public class WestEastCar extends Vehicle {
	
	public WestEastCar(int size, int speed, int verticalLane, int horizontalLane, char symbol)
	{
		super(size, speed, verticalLane, horizontalLane, symbol);		
		this.currentCell = null;
	}

	@Override
	/*
	 * Moves the car across the intersection by successively entering the next cell.
	 * West-East cars start in the first column and move right without changing their horizontal lane.
	 */
	public void move() 
	{
		//For each cell in the West-East car's horizontal lane, starting from the leftmosts.
		for(int pos = verticalLane; pos < this.crossing.getCols(); pos++)
		{
			//Try to enter next cell in intersection.
			crossing.getSpecificCell(horizontalLane, pos).enter(this);
			try
			{
				Thread.sleep(this.speed);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//Exit last cell in intersection]k,9.
		currentCell.exit();

	}

}
