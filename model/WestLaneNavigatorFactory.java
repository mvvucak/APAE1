package model;

public class WestLaneNavigatorFactory implements NavigatorFactory {

	@Override
	public Navigator createNavigator(int lane) {
		// TODO Auto-generated method stub
		return (new WestLaneNavigator(lane));
	}

}
