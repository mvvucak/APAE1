package model;

public abstract class Navigator {
	
	protected char marker;
	
	public Navigator(char marker)
	{
		this.marker = marker;
	}

	public abstract Cell getNextCell();
	
	public abstract boolean isOnLastCell();
	
	public char getMarker()
	{
		return this.marker;
	}

}
