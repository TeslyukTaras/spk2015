package selector;

import java.util.Arrays;

import model.Gene;
import sorter.BaseSorter;
import utils.Constants;

public class BaseSelector {
	public static Gene[] naturalSelection(Gene[] genes){
		Gene[] res = new Gene[Constants.POPULATION_SIZE];
		
		if(Constants.FIND_MIN)
			Arrays.sort(genes, BaseSorter.comparatorIncrease);
		else
			Arrays.sort(genes, BaseSorter.comparatorDecrease);
		//get best
		for(int i = 0; i < Constants.POPULATION_SIZE; i++){
			res[i] = genes[i];
		}
		return res;
	}
}
