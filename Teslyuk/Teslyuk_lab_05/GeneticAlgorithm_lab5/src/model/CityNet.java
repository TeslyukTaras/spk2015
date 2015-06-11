package model;

public class CityNet {
	
	private static CityNet instance;
	
	public static CityNet getInstance(){
		if(instance!=null) return instance;
		else return null;
	}
	
	public static CityNet getInstance(Point[] coors){
		instance = new CityNet(coors);
		return instance;
	}
	
	public CityNet(Point[] coors) {
		this.coor = coors;
		this.cities = coors.length;
	}
	
	private int cities;
	private Point[] coor;
	
	public Point[] getPoints(){
		return coor;
	}
}
