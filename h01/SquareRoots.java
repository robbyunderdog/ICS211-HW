package edu.ics211.h01;

public class SquareRoots {
	
	public static double[] SqrtArr(int a) {
		
		if (a < 2) {    //kills inputs that are less than 2
			System.out.print("Input was invalid, integer has to be 2 or greater.");
			return new double[0];
		} 			
		double[] doubleArray = new double[a - 1];    //creates a new array of doubles with the appropriate length
		
		for (int i = 2; i <= a; i++) {
			doubleArray[i-2] = Math.sqrt(i);    //square roots the values from 2 to the argument and writes it to the array
		}
		return doubleArray;    //returns the array
	}
}
