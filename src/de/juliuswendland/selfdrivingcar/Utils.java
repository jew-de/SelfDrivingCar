package de.juliuswendland.selfdrivingcar;

public class Utils {

	public static final int INFINITY = 999999999;
	
	/**
	 * 
	 * linear interpolation
	 * @param A	lowest number
	 * @param B	higheset number
	 * @param t percentage from 0 to 1
	 * @return	a value betweeen A and B
	 */
	public static double lerp(double A, double B, double t) {
		
		return A + (B - A) * t;
		
	}
	
}
