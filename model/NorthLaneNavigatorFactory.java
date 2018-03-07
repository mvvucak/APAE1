package model;

public class NorthLaneNavigatorFactory extends LaneNavigatorFactory {
	
	public NorthLaneNavigatorFactory(LaneChooser chooser)
	{
		super(chooser);
	}

	@Override
	public Navigator createLaneNavigator(int lane) {
		
		return (new NorthLaneNavigator(lane));
	}

}
