package core;

import utils.Constants;

public class BaseFunction {
	//f(x) = a + bx + cx2 + dx3
	
	public static float calculate(float x){
		float res = Constants.COEF_A +
				Constants.COEF_B*x + 
				Constants.COEF_C*x*x+
				Constants.COEF_D*x*x*x;
		return res;
	}
	
}
