package model;

public final class NorthSouthCar extends Vehicle {

	public NorthSouthCar(int size, int speed, int startingPosition, char symbol)
	{
		super(size, speed, startingPosition, symbol);	
	}
	
	@Override
	public void move() {
		for(int pos = 0; pos < this.crossing.getRows(); pos++)
		{
			crossing.getSpecificCell(pos, startingPosition).enter(this);
			try
			{
				Thread.sleep(this.speed);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			crossing.getSpecificCell(pos, startingPosition).exit();
		}

	}

}
