package model;

public class EastLaneNavigatorFactory extends LaneNavigatorFactory {
	
	public EastLaneNavigatorFactory(LaneChooser chooser)
	{
		super(chooser);
	}
	
	@Override
	public Navigator createLaneNavigator(int lane) {
		// TODO Auto-generated method stub
		return (new EastLaneNavigator(lane));
	}

}
