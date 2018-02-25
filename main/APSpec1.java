package main;

import model.*;

public class APSpec1 {

	public static void main(String[] args) {
		Intersection crossing = Intersection.getInstance(10, 10);
		
		Thread[] threads = new Thread[10];
		TrafficGenerator[] generators = new TrafficGenerator[10];
		generators[0] = new WestEastGenerator();
		generators[1] = new NorthSouthGenerator();
		threads[0] = new Thread(generators[0]);
		threads[1] = new Thread(generators[1]);
		
		threads[0].start();
		threads[1].start();
		
		int max = 2000;
		
		for(int i=1; i<=max; i++)
		{
			try {
				Thread.sleep(20);
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("This is print:" + i);
			System.out.println(crossing.getPrintOut());
			
		}
		
	}

}
