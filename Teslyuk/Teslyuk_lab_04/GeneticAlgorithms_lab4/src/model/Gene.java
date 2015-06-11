package model;

import converter.FloatConverter;

public class Gene {
	private byte[] genes;
	
	public Gene(byte[] genes){
		this.genes = genes;
	}
	
	public byte[] getGenes(){
		return genes;
	}

	public void mutate(int i) {
		if(i < genes.length){
			if(genes[i]==0) genes[i] = 1;
			else genes[i] = 0;
		}
	}
	
	public float getFloatValue(){
		return FloatConverter.byteArrayToFloat(genes);
	}
}
