package solver;

import java.util.Arrays;

import core.BaseFunction;
import generator.PopulationGenerator;
import model.Gene;
import selector.BaseSelector;
import sorter.BaseSorter;
import utils.Constants;
import breader.BaseBreader;

public class BaseSolver {
	Gene[] initialPopulation;
	Gene[] breadedPopulation;
	Gene[] selectedPopulation;
	
	public BaseSolver(){
		Gene[] initialPopulation = PopulationGenerator.generatePopulation(Constants.POPULATION_SIZE);
		if(Constants.FIND_MIN)
			Arrays.sort(initialPopulation, BaseSorter.comparatorIncrease);
		else
			Arrays.sort(initialPopulation, BaseSorter.comparatorDecrease);
		printPopulation("Base population",initialPopulation);
		selectedPopulation = initialPopulation;
		
		System.out.println("mediumX:"+calmMediumX(selectedPopulation)+" mediumY:"+calcMediumY(selectedPopulation));
		
		for(int i=0;i<Constants.ITERATIONS; i++){
			breadedPopulation = BaseBreader.bread(selectedPopulation);
			if(Constants.FIND_MIN)
				Arrays.sort(breadedPopulation, BaseSorter.comparatorIncrease);
			else
				Arrays.sort(breadedPopulation, BaseSorter.comparatorDecrease);
			//printPopulation("Base breading",breadedPopulation);
			
			selectedPopulation = BaseSelector.naturalSelection(breadedPopulation);
			if(Constants.FIND_MIN)
				Arrays.sort(selectedPopulation, BaseSorter.comparatorIncrease);
			else
				Arrays.sort(selectedPopulation, BaseSorter.comparatorDecrease);
			
			printPopulation("iteration#"+i+" population",selectedPopulation);
			
			float mediumX = calmMediumX(selectedPopulation);
			float mediumY = calcMediumY(selectedPopulation);
			System.out.println("iteration:"+i+" mediumX:"+mediumX+" mediumY:"+mediumY);
		}
		
		printPopulation("Final population",selectedPopulation);
	}
	
	
	
	private float calcMediumY(Gene[] population) {
		float res = 0.0f;
		for(int i = 0; i < population.length; i++){
			res+=BaseFunction.calculate(population[i].getFloatValue());
		}
		res/=population.length;
		return res;
	}



	private float calmMediumX(Gene[] population) {
		float res = 0.0f;
		for(int i = 0; i < population.length; i++){
			res+=population[i].getFloatValue();
		}
		res/=population.length;
		return res;
	}



	private void printPopulation(String title, Gene[] genes){
		System.out.println(title);
		for(int i = 0; i < genes.length; i++){
			byte[] arr = genes[i].getGenes();
			float v = genes[i].getFloatValue();
			float value = BaseFunction.calculate(v);
			System.out.println(i+" v:"+v+" value:"+value+" arr:"+Arrays.toString(arr));
		}
	}
}
