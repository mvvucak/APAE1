package model;

public class WestEastCar extends Vehicle {
	
	public WestEastCar(int size, int speed, int startingPosition, char symbol)
	{
		super(size, speed, startingPosition, symbol);	
	}

	@Override
	public void move() 
	{
		for(int pos = 0; pos < this.crossing.getCols(); pos++)
		{
			crossing.getSpecificCell(startingPosition, pos).enter(this);
			try
			{
				Thread.sleep(this.speed);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			crossing.getSpecificCell(startingPosition, pos).exit();
		}

	}

}
