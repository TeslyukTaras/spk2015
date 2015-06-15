package core;

import generator.PopulationGenerator;

import java.util.Arrays;

import breader.BaseBreader;
import solver.BaseSolver;
import utils.Constants;
import model.Gene;
import converter.FloatConverter;

public class Core {

	public Core(){
		BaseSolver solver = new BaseSolver();
	}
	
	public static void main(String[] args) {
		new Core();
	}

	
}
