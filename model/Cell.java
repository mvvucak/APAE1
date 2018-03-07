package model;

import java.util.concurrent.locks.*;


public class Cell {
	
	private Vehicle occupant;
	private ReentrantLock lock;
	private Condition occupied;
	private boolean isOccupied;
	
	public Cell()
	{
		this.occupant = null;
		this.lock = new ReentrantLock();
		this.occupied = lock.newCondition();
		this.isOccupied = false;
	}
	
	public void enter(Vehicle v)
	{
		lock.lock();
		try
		{
			while(this.isOccupied)
			{
				occupied.await();
			}
			//If the vehicle is already in a cell, leave that cell.
			if(v.getCurrentCell() != null) v.leaveCell();
			this.occupant = v;
			v.setCurrentCell(this);
			this.isOccupied = true;
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public void exit()
	{
		lock.lock();
		this.occupant = null;
		this.isOccupied = false;
		occupied.signalAll();
		lock.unlock();
	}
	
	public String getPrintOut()
	{
		if(this.occupant != null)
		{
			return "|"+this.occupant.getSymbol();
		}
		else
		{
			return "| ";
		}
	}
	
	public Vehicle getOccupant()
	{
		return this.occupant;
	}

}
