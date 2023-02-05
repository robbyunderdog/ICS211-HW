package edu.ics211.h01;

/* ICS 211 Assignment 01
Robert Warner Section 2
Due January 20, 2023 */

public class HW1 {

	public static void main(String[] args) {
		
		double rDouble = Math.random();    //generates random number from 0-10
		int rInt = (int) (rDouble * 11);
		
		double[] doubArr = SquareRoots.SqrtArr(rInt);    //calls square root array method to create the array
		
		for (int i=0; i < doubArr.length; i++) {    //prints out the array
			System.out.print(doubArr[i] + ",");
		}
		
		System.out.print("\n\n");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + "   " + ReadingFiles.FileChar(args[i]));    //calls file reader method and 
		}
	}
}