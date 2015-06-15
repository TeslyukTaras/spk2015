package core;

import utils.Constants;

public class AnaliticalMethod {
	private static float MIN_DELTA = 0.01f;
	private static int STEPS_COUNT = 10;
	
	public float bestX, bestY;
	
	float left, right;
	
	public AnaliticalMethod(){
		
	}
	
	public static void main(String[] args){
		AnaliticalMethod method = new AnaliticalMethod();
		method.solve(-10f, 54f);
		System.out.println("best x:"+method.bestX+" y:"+method.bestY);
	}
	
	public void solve(float left, float right){
		this.left = left;
		this.right = right;
		if(Constants.FIND_MIN) bestY = Float.MAX_VALUE;
		else bestY = Float.MIN_VALUE;
		
		float x,y;
		float newLeft, newRight;
		int bestIteration = 0;
		while(right-left>=MIN_DELTA){
			System.out.println("left:"+left+" right:"+right);
			bestIteration = 0;
			for(int i = 0; i <= STEPS_COUNT; i++){
				x = left+(right-left)/STEPS_COUNT*i;
				y = BaseFunction.calculate(x);
				
				if(Constants.FIND_MIN){
					if(bestY>y){
						bestY = y;
						bestX = x;
						bestIteration = i;
					}
				}else{
					if(bestY<y){
						bestY = y;
						bestX = x;
						bestIteration = i;
					}
				}
			}
			
			if(bestIteration!=STEPS_COUNT){
				newLeft = left+(right-left)/STEPS_COUNT*bestIteration;
				newRight =  left+(right-left)/STEPS_COUNT*(bestIteration+1);
			}else{
				newLeft = left+(right-left)/STEPS_COUNT*(bestIteration-1);
				newRight =  left+(right-left)/STEPS_COUNT*(bestIteration);
			}
			
			left = newLeft;
			right = newRight;
		}
	}
	
}
