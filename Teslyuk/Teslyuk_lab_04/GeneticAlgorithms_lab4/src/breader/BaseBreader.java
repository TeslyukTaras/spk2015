package breader;

import java.util.Arrays;
import java.util.Random;

import model.Gene;
import utils.Constants;

public class BaseBreader {
	private static Random rand = new Random();
	
	public static Gene[] bread(Gene[] parents){
		//System.out.println("Bread");
		
		Gene[] res = new Gene[Constants.SELECTION_SIZE];
		
		int current = 0;
		
		for(int i = 0; i < parents.length-1; i++){
			for(int j = i+1; j < parents.length; j++){
				//System.out.println("i:"+i+" j:"+j);
				Gene[] currentGenes = makeChilds(parents[i], parents[j]);
				for(int z=0;z<currentGenes.length; z++){
					//System.out.println("z:"+z);
					addMutation(currentGenes[z]);
					res[current+z] = currentGenes[z];
				}
				current+=currentGenes.length;
			}
		}
		
//		int current = 0;
//		while(current < Constants.SELECTION_SIZE){
//			int parent1 = rand.nextInt(parents.length);
//			int parent2 = rand.nextInt(parents.length);
//			if(parent1!=parent2){
//				Gene currentGene = makeChild(parents[parent1], parents[parent2]);
//				addMutation(currentGene);
//				res[current] = currentGene;
//				current++;	
//			}
//			
//		}
		return res;
	}
	
	public static Gene[] bread2(Gene[] parents){
		//System.out.println("Bread");
		
		Gene[] res = new Gene[Constants.SELECTION_SIZE];
		
		
		int current = 0;
		while(current < Constants.SELECTION_SIZE){
			int parent1 = rand.nextInt(parents.length);
			int parent2 = rand.nextInt(parents.length);
			if(parent1!=parent2){
				Gene currentGene = makeChild(parents[parent1], parents[parent2]);
				addMutation(currentGene);
				res[current] = currentGene;
				current++;	
			}
			
		}
		return res;
	}

	private static void addMutation(Gene currentGene) {
		for(int i = 0; i < currentGene.getGenes().length; i++){
			if(rand.nextDouble()<=Constants.MUTATION_PROBABILITY){
				currentGene.mutate(i);
			}
		}
	}

	private static Gene[] makeChilds(Gene p1, Gene p2) {
//		System.out.println("makeChilds");
		
		byte[] g1 = p1.getGenes();
		byte[] g2 = p2.getGenes();
		int length = Math.min(g1.length, g2.length);
		byte[] child1 = new byte[length];
		byte[] child2 = new byte[length];
		
		int crossPoint = 1+rand.nextInt(length-2);
		boolean isFirstParent = rand.nextBoolean();
		
		for(int i=0;i<crossPoint; i++){
			if(isFirstParent){
				child1[i] = g1[i];
				child2[i] = g2[i];
			}
			else{
				child1[i] = g2[i];
				child2[i] = g1[i];
			}
		}
		
		for(int i=crossPoint;i<length; i++){
			if(!isFirstParent){
				child1[i] = g1[i];
				child2[i] = g2[i];
			}
			else{
				child1[i] = g2[i];
				child2[i] = g1[i];
			}
		}
		
		return new Gene[]{
				new Gene(child1),
				new Gene(child2)
				};
	}
	
	private static Gene makeChild(Gene p1, Gene p2) {
//		System.out.println("Breader");
		
		byte[] g1 = p1.getGenes();
		byte[] g2 = p2.getGenes();
		int length = Math.min(g1.length, g2.length);
		byte[] child1 = new byte[length];
		
		int crossPoint = 1+rand.nextInt(length-2);
		boolean isFirstParent = rand.nextBoolean();
		
		for(int i=0;i<crossPoint; i++){
			if(isFirstParent){
				child1[i] = g1[i];
			}
			else{
				child1[i] = g2[i];
			}
		}
		
		for(int i=crossPoint;i<length; i++){
			if(!isFirstParent){
				child1[i] = g1[i];
			}
			else{
				child1[i] = g2[i];
			}
		}
		
//		for(int i = 0; i < length; i++){
//			child1[i] = rand.nextBoolean()?g1[i]:g2[i];
//			child2[i] = rand.nextBoolean()?g1[i]:g2[i];
//		}
		
//		System.out.println("p1:"+Arrays.toString(g1));
//		System.out.println("p2:"+Arrays.toString(g2));
//		System.out.println("c:"+Arrays.toString(child));
		
		return new Gene(child1);
	}
}
