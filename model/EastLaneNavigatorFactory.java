package model;

public class EastLaneNavigatorFactory implements NavigatorFactory {

	@Override
	public Navigator createNavigator(int lane) {
		// TODO Auto-generated method stub
		return (new EastLaneNavigator(lane));
	}

}
