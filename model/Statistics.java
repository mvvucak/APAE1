package model;

public class Statistics {
	
	private TrafficGenerator[] generators;
	
	public Statistics(TrafficGenerator[] generators)
	{
		this.generators = generators;
	}
	
	public void printStatistics()
	{
		//For each generator used.
		for(int i = 0; i<generators.length; i++)
		{
			//Calculate statistics and print them out.
			long maxTime = getMaxTime(i);
			long minTime = getMinTime(i);
			
			double meanTime = getMeanTime(i);
			double variance = getVariance(i);
			
			//Get number of vehicles generator made and how many crossed the intersection.
			int vehiclesMade = generators[i].getVehiclesMade();
			int vehiclesCrossed = getNoVehiclesCrossed(i);
			
			
			String name = generators[i].getName();
			int firstLane = generators[i].getFirstLane()+1;
			int lastLane = generators[i].getLastLane();
			
			
			System.out.println("Statistics for " + name);
			System.out.print("First lane: "+ firstLane + ". ");
			System.out.println("Last lane: " + lastLane + ".");
			System.out.println("Vehicles made: " + vehiclesMade);
			System.out.println("Vehicles that completed crossing: " + vehiclesCrossed);
			System.out.println("Maximum travel time: " + maxTime);
			System.out.println("Minimum travel time: " + minTime);
			System.out.println("Mean travel time: " + meanTime);
			System.out.println("Travel time variance: " + variance);
			System.out.println("");
		}
	}
	
	private final double getMeanTime(int i)
	{
		Long[] travelTimes = generators[i].getTravelTimes();
		double meanTime = 0.0;
		for(long j: travelTimes)
		{
			meanTime += j;
		}
		meanTime = meanTime/travelTimes.length;
		return meanTime;
	}
	
	private final long getMaxTime(int i)
	{
		Long[] travelTimes = generators[i].getTravelTimes();
		long max = travelTimes[0];
		for(long j: travelTimes)
		{
			if(j>max)
			{
				max = j;
			}
		}
		return max;
	}
	
	private final int getNoVehiclesCrossed(int i)
	{
		Long[] travelTimes = generators[i].getTravelTimes();
		return travelTimes.length;
	}
	
	private final long getMinTime(int i)
	{
		Long[] travelTimes = generators[i].getTravelTimes();
		long min = travelTimes[0];
		for(long j: travelTimes)
		{
			if(j<min)
			{
				min = j;
			}
		}
		return min;
	}
	
	private final double getVariance(int i)
	{
		double meanTime = getMeanTime(i);
		Long[] travelTimes = generators[i].getTravelTimes();
		double variance = 0.0;
		for(long j: travelTimes)
		{
			variance += (j-meanTime)*(j-meanTime);
		}
		variance = variance/(travelTimes.length-1);
		return variance;
		
	}

}
