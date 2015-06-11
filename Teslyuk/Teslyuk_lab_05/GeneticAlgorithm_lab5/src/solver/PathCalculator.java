package solver;

import model.CityNet;
import model.Gene;
import model.Point;

public class PathCalculator {
	
	public static float findPathLength(Gene gene){
		float res = 0.0f;
		byte[] path = gene.getGenes();
		int length = path.length;
		for(int i=0;i<length;i++){
			if(i==length-1){
				res+=getDistance(path[i], path[0]);
			}else{
				res+=getDistance(path[i], path[i+1]);
			}
		}
		
		return res;
	}
	
	private static float getDistance(int f, int t){
		Point fp = CityNet.getInstance().getPoints()[f];
		Point tp = CityNet.getInstance().getPoints()[t];
		
		float res = 0.0f;
		res = (float) Math.sqrt(Math.pow(fp.x-tp.x, 2) + Math.pow(fp.y-tp.y, 2));
		
		return res;
	}
}
