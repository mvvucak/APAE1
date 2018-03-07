package model;

public abstract class LaneNavigatorFactory implements NavigatorFactory {
	
	protected LaneChooser chooser;
	
	public LaneNavigatorFactory(LaneChooser chooser)
	{
		this.chooser = chooser;
	}

	@Override
	public Navigator createNavigator() 
	{
		return createLaneNavigator(chooser.chooseLane());
	}
	
	public abstract Navigator createLaneNavigator(int lane);

}
