package model;

public class NorthLaneNavigatorFactory implements NavigatorFactory {

	@Override
	public Navigator createNavigator(int lane) {
		
		return (new NorthLaneNavigator(lane));
	}

}
