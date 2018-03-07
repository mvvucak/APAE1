package model;

public class SouthLaneNavigatorFactory extends LaneNavigatorFactory {
	
	public SouthLaneNavigatorFactory(LaneChooser chooser)
	{
		super(chooser);
	}

	@Override
	public Navigator createLaneNavigator(int lane) {
		// TODO Auto-generated method stub
		return (new SouthLaneNavigator(lane));
	}

}
