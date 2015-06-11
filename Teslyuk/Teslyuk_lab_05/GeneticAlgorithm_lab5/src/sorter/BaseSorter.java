package sorter;

import java.util.Comparator;

import solver.PathCalculator;
import model.Gene;

public class BaseSorter {
	public static Comparator<Gene> comparatorIncrease = new Comparator<Gene>() {
		
		@Override
		public int compare(Gene o1, Gene o2) {
			float f1 = o1.getPath();
			float f2 = o2.getPath();
			
			if(f1>f2) return 1;
			else if(f1==f2) return 0;
			else return -1;
		}
	};
	
	public static Comparator<Gene> comparatorDecrease = new Comparator<Gene>() {
		
		@Override
		public int compare(Gene o1, Gene o2) {
			float f1 = PathCalculator.findPathLength(o1);
			float f2 = PathCalculator.findPathLength(o2);
			
			if(f1>f2) return -1;
			else if(f1==f2) return 0;
			else return 1;
		}
	};
}
