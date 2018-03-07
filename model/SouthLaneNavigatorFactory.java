package model;

public class SouthLaneNavigatorFactory implements NavigatorFactory {

	@Override
	public Navigator createNavigator(int lane) {
		// TODO Auto-generated method stub
		return (new SouthLaneNavigator(lane));
	}

}
