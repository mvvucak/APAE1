package main;

import model.*;

public class APSpec1 {

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		Vehicle[] cars = new Vehicle[10];
		WestEastCarFactory westEastFactory = new WestEastCarFactory();
		NorthSouthCarFactory northSouthFactory = new NorthSouthCarFactory();
		Intersection crossing = Intersection.getInstance(10, 10);
		for(int i=0; i<10; i++)
		{
			if(i%2==0)
			{
				cars[i] = westEastFactory.createVehicle(600, i);
			}
			else
			{
				cars[i] = northSouthFactory.createVehicle(1000, i);
			}
			
			threads[i] = new Thread(cars[i]);
		}
		for(int i = 0; i<10;i++)
		{
			threads[i].start();
		}
		int max = 1000;
		
		for(int i=1; i<=max; i++)
		{
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("This is print:" + i);
			System.out.println(crossing.getPrintOut());
			
		}
		
	}

}
