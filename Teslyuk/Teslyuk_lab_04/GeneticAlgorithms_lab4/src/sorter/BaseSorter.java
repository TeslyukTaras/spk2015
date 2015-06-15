package sorter;

import java.util.Comparator;

import model.Gene;
import converter.FloatConverter;
import core.BaseFunction;

public class BaseSorter {
	public static Comparator<Gene> comparatorIncrease = new Comparator<Gene>() {
		
		@Override
		public int compare(Gene o1, Gene o2) {
			
			float v1 = FloatConverter.byteArrayToFloat(o1.getGenes());
			float v2 = FloatConverter.byteArrayToFloat(o2.getGenes());
			
			float f1 = BaseFunction.calculate(v1);
			float f2 = BaseFunction.calculate(v2);
			
			if(f1>f2) return 1;
			else if(f1==f2) return 0;
			else return -1;
		}
	};
	
	public static Comparator<Gene> comparatorDecrease = new Comparator<Gene>() {
		
		@Override
		public int compare(Gene o1, Gene o2) {
			
			float v1 = FloatConverter.byteArrayToFloat(o1.getGenes());
			float v2 = FloatConverter.byteArrayToFloat(o2.getGenes());
			
			float f1 = BaseFunction.calculate(v1);
			float f2 = BaseFunction.calculate(v2);
			
			if(f1>f2) return -1;
			else if(f1==f2) return 0;
			else return 1;
		}
	};
}
