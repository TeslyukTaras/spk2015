package solver;

import java.util.Arrays;

import generator.MapGenerator;
import generator.PopulationGenerator;
import model.CityNet;
import model.Gene;
import model.Point;
import selector.BaseSelector;
import sorter.BaseSorter;
import utils.Constants;
import breader.BaseBreader;

public class BaseSolver {
	Gene[] initialPopulation;
	Gene[] breadedPopulation;
	Gene[] selectedPopulation;
	
	public BaseSolver(){
		//generate MAP
		Point[] points = MapGenerator.generateMap();
//		Point[] points = MapGenerator.generateDefaultMap();
		CityNet.getInstance(points);
		//generate population
		Gene[] initialPopulation = PopulationGenerator.generatePopulation(Constants.POPULATION_SIZE);
		if(Constants.FIND_MIN)
			Arrays.sort(initialPopulation, BaseSorter.comparatorIncrease);
		else
			Arrays.sort(initialPopulation, BaseSorter.comparatorDecrease);
		printPopulation("Base population",initialPopulation);
		selectedPopulation = initialPopulation;
		
		System.out.println("initial mediumY:"+calcMediumY(selectedPopulation)+" minY:"+calcMinY(selectedPopulation));
		
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
			
			//printPopulation("iteration#"+i+" population",selectedPopulation);
			
			float mediumY = calcMediumY(selectedPopulation);
			float minY = calcMinY(selectedPopulation);
			System.out.println("iteration:"+i+" mediumY:"+mediumY+" minY:"+minY);
		}
		
		printPopulation("Final population",selectedPopulation);
	}
	
	
	
	private float calcMediumY(Gene[] population) {
		float res = 0.0f;
		for(int i = 0; i < population.length; i++){
			res+=population[i].getPath();
		}
		res/=population.length;
		return res;
	}

	
	private float calcMinY(Gene[] population) {
		float res = Float.MAX_VALUE;
		for(int i = 0; i < population.length; i++){
			if(res>population[i].getPath()) res = population[i].getPath();
		}
		return res;
	}



	private void printPopulation(String title, Gene[] genes){
		System.out.println(title);
		for(int i = 0; i < genes.length; i++){
			byte[] arr = genes[i].getGenes();
			float value = genes[i].getPath();
			System.out.println(i+" value:"+value+" arr:"+Arrays.toString(arr));
		}
	}
}
