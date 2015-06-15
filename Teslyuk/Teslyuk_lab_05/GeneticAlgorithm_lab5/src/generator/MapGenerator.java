package generator;

import java.util.Random;

import model.Point;
import utils.Constants;

public class MapGenerator {
	
	private static int[] xcoor = new int[]{
			3,9,3,7,8,3,9,7,3,3
	};
	
	private static int[] ycoor = new int[]{
			6,1,6,2,4,2,6,3,3,1
	};
	
	private static Random rand = new Random();
	
	public static Point[] generateMap(){
		int point = Constants.CITY_COUNT;
		
		Point[] res = new Point[point];
		
		int x,y;
		for(int i = 0; i < point; i++){
			x = rand.nextInt(Constants.MAX_X);
			y = rand.nextInt(Constants.MAX_Y);
			
			res[i] = new Point(x, y);
			System.out.println("add point x:"+x+" y:"+y);
		}
		
		return res;
	}
	
	public static Point[] generateDefaultMap(){
		int point = Constants.CITY_COUNT;
		
		Point[] res = new Point[point];
		
		int x,y;
		for(int i = 0; i < point; i++){
			x = xcoor[i];
			y = ycoor[i];
			
			res[i] = new Point(x, y);
			System.out.println("add point x:"+x+" y:"+y);
		}
		
		return res;
	}
}
