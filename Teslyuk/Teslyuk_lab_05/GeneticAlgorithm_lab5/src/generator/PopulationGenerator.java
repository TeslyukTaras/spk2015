package generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import utils.Constants;
import model.Gene;

public class PopulationGenerator {
	
	private static Random rand = new Random();
	
	public static Gene[] generatePopulation(int size){
		System.out.println("generatePopulation");
		Gene[] res = new Gene[size];
		List<Byte> list = new ArrayList<Byte>();
		
		for(int i = 0; i < size; i++){
			list.clear();
			
			for(int j = 0; j < Constants.CITY_COUNT; j++){
				list.add((byte) j);
			}
			
			byte[] arr = new byte[Constants.CITY_COUNT];
			
			while(!list.isEmpty()){
				int pos = rand.nextInt(list.size());
				arr[list.size()-1] = (byte) list.get(pos);
				list.remove(pos);
			}
			
			res[i] = new Gene(arr);
			
			System.out.println("generate item #"+i+" arr:"+Arrays.toString(arr));
		}
		return res;
	}
}
