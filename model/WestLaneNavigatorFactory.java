package model;

public class WestLaneNavigatorFactory extends LaneNavigatorFactory{
	
	public WestLaneNavigatorFactory(LaneChooser chooser)
	{
		super(chooser);
	}

	@Override
	public Navigator createLaneNavigator(int lane) {
		// TODO Auto-generated method stub
		return (new WestLaneNavigator(lane));
	}

}
