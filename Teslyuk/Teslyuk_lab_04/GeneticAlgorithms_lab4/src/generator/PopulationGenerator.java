package generator;

import java.util.Arrays;
import java.util.Random;

import utils.Constants;
import converter.FloatConverter;
import model.Gene;

public class PopulationGenerator {
	private static Random rand = new Random();
	
	public static Gene[] generatePopulation(int size){
		Gene[] res = new Gene[size];
		for(int i = 0; i < size; i++){
			float value = (float)rand.nextInt(64) + 
					(float)rand.nextInt(100)/100.0f - 
					Constants.SHIFT;
			byte[] arr = FloatConverter.floatToByteArray(value);
			float v = FloatConverter.byteArrayToFloat(arr);
			res[i] = new Gene(arr);
			//System.out.println("new item value:"+value+" v:"+v+" arr: "+Arrays.toString(arr));
		}
		return res;
	}
}
