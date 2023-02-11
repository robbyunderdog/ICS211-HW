package edu.ics211.h04;

import java.util.Arrays;

/**
 * SortedArrayList class, provides multiple methods to emulate the official arraylist class, but with sorting
 * @author Robert Warner
 */

public class SortedArrayList implements SortedArrayListInterface{
	String[] data;    // MAIN STRING ARRAY WE ARE DEALING WITH
	int num = 0;
	
	public SortedArrayList() {    // constructor sets array length to 1
		data = new String[1];
	}

	@Override
	public int size() {    // RETURNS NUMBER OF STRINGS IN ARRAY
		return num;
	}

	@Override
	public String get(int index) { // check if index is out of array, else return the string
		return data[index];
	}

	@Override
	public boolean add(String value) {    //adds given value to main array, sorting 
		String[] origData = data;
		if (data.length == num) {
			// INCREASES ARRAY LENGTH
			data = Arrays.copyOf(data, data.length + 3);    //O(N) time complexity, has to iterate through the array to copy it.
		}
		// ADDS NEW VALUE AND SORTS
		data[num] = value;
		for (int i = num; i > 0; i--) { 
			if (data[i].compareToIgnoreCase(data[i - 1]) == 0) {    // if the new value is equal, we revert the changes and return false
				data = origData;
				return false;
				
			} else if (data[i].compareToIgnoreCase(data[i - 1]) < 0) {    // if new value compared is less than 0, we swap the values					
				String temp = data[i - 1];
				data[i-1] = data[i];
				data[i] = temp;
			} else {    // else the new value is in the correct space and we break from the loop
				break;
			}			
		}
		num++;    //increases total number of strings in the main array
		return true;
	}

	@Override
	public boolean remove(String value) {    // removes given value from main string array, shifting all other values forward
		for (int i = 0; i < data.length; i++) {
			if (value.compareToIgnoreCase(data[i]) == 0) {
				data[i] = null;
				for (int j = i; j < data.length - 1; j++) {
					data[j] = data[j + 1];
				}
				num--;
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(String value) {    // returns index value of given string value, else returns -1
		for (int i = 0; i < data.length; i++) {
			if (data[i].compareToIgnoreCase(value) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < size(); i++) {
			result = result + data[i] + " ";
		}
		result = result.trim();
		return result;
	}
}
