package main;

import model.*;
import view.*;

public class APSpec1 {

	public static void main(String[] args) 
	{
		Intersection crossing = Intersection.getInstance(10, 20);
		
		int iterations = 1000;
		int printInterval = 20;
		IntersectionView view = new IntersectionView(iterations, printInterval);
		
		//Instantiate Lane Choosers
		RandomLaneChooser horizontal = new RandomLaneChooser(crossing.getRowIndices());
		SequentialLaneChooser vertical = new SequentialLaneChooser(crossing.getColIndices());
		
		//Instantiate Navigator Factories
		SouthLaneNavigatorFactory sFactory = new SouthLaneNavigatorFactory(vertical);
		EastLaneNavigatorFactory eFactory = new EastLaneNavigatorFactory(horizontal);
		
		//Instantiate Traffic Generators
		TrafficGenerator[] generators = new TrafficGenerator[2];
		generators[0] = new UniformGenerator(new CarFactory(sFactory));
		generators[1] = new UniformGenerator(new CarFactory(eFactory));
		
		Thread[] threads = new Thread[10];
		threads[0] = new Thread(generators[0]);
		threads[1] = new Thread(generators[1]);
		
		threads[9] = new Thread(view);
		
		threads[0].start();
		threads[1].start();
		threads[9].start();
		
		try
		{
			threads[9].join();
		}
		catch(InterruptedException e)
		{}
		
		Vehicle.stopMovement();
		generators[0].finish();
		generators[1].finish();
		
		Statistics stats = new Statistics(generators);
		
		System.out.println("West East Generator created " + generators[1].getVehiclesMade() + " cars.");
		System.out.println("North South Generator created " + generators[0].getVehiclesMade()+ " cars.");
		stats.printStatistics();
		
		
		
	}

}
