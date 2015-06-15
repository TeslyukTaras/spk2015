package model;

import solver.PathCalculator;


public class Gene {
	private byte[] genes;
	private float path;
	
	public Gene(byte[] genes){
		this.genes = genes;
		this.path = PathCalculator.findPathLength(this);
	}
	
	public byte[] getGenes(){
		return genes;
	}

	public void setValue(int position, byte value){
		if(position<genes.length){
			genes[position] = value;
		}
	}
	
	public float getPath(){
		return path;
	}
	
}
