package view;
import model.*;

public class IntersectionView implements Runnable {
	
	//The number of times the intersection is to be printed out.
	private int iterations;
	//The time in ms between each print out.
	private int printInterval;
	//The intersection instance.
	private Intersection crossing;
	
	public IntersectionView(int iterations, int printInterval)
	{
		this.crossing = Intersection.getInstance();
		this.iterations = iterations;
		this.printInterval = printInterval;
	}
	
	public void run()
	{
		for(int i=1; i<=iterations; i++)
		{
			try {
				Thread.sleep(this.printInterval);
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println("This is print:" + i);
			System.out.println("");
			System.out.println(crossing.getPrintOut());
			
			
		}
	}
	

}
