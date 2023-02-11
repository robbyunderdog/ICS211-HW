package edu.ics211.h04;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

class UnitTest {

	@Test
	void testConstructor1() {    // constructor test1
		SortedArrayList list = new SortedArrayList();    // checks if the constructor works correctly, setting the starting array length to 1
		assert(list.data.length == 1);
	}
	@Test
	void testAdd1() {    // add() test1
		SortedArrayList list = new SortedArrayList();    // checks if adding and sorting of the add method are correct
		list.add("Robby");
		assert(list.data[0].equals("Robby"));
		list.add("Joseph");
		assert(list.data.length == 4);
		assert(list.data[0].equals("Joseph"));
		list.add("Abby");
		assert(list.data[0].equals("Abby"));
		assert(list.data[1].equals("Joseph"));
		assert(list.data[2].equals("Robby"));
	}
	@Test
	void testAdd2() {
		SortedArrayList list = new SortedArrayList();    // checks if the add method returns false if a duplicate value is attempted to be added
		list.add("Robby");
		list.add("Joseph");
		list.add("Jason");
		list.add("Abby");
		assert(list.data[0].equals("Abby"));
		assert(list.data[1].equals("Jason"));
		assert(list.data[2].equals("Joseph"));
		assert(list.data[3].equals("Robby"));
		list.add("Kenneth");
		assert(list.data.length == 7);
		assert(list.data[3].equals("Kenneth"));
		assertFalse(list.add("Abby"));
	}
	@Test
	void testSize() {
		SortedArrayList list = new SortedArrayList();    // checks if the size function works properly
		assert(list.size() == 0);
		list.add("Robby");
		list.add("Joseph");
		assert(list.size() == 2);
	}
	@Test
	void testRemove1() {
		SortedArrayList list = new SortedArrayList();    // checks if the remove method adds and shifts other values correctly
		list.add("Robby");
		list.add("Joseph");
		list.add("Abby");
		list.add("Kenneth");
		assert(list.data[0].equals("Abby"));
		assert(list.data[1].equals("Joseph"));
		assert(list.data[2].equals("Kenneth"));
		assert(list.data[3].equals("Robby"));
		list.remove("Abby");
		assert(list.data[0].equals("Joseph"));
		assert(list.data[1].equals("Kenneth"));
		assert(list.data[2].equals("Robby"));
		list.remove("Robby");
		assert(list.size() == 2);
	}
	@Test
	void testIndexOf() {
		SortedArrayList list = new SortedArrayList();    // checks of indexOf method properly returns the correct index of the wanted string
		list.add("Robby");
		list.add("Joseph");
		list.add("Abby");
		list.add("Kenneth");
		assert(list.indexOf("Kenneth") == 2);
	}
	@Test
	void testGet() {
		SortedArrayList list = new SortedArrayList();    // checks if get method works properly and returns the correct string
		list.add("Robby");
		list.add("Joseph");
		list.add("Abby");
		assert(list.get(1).equals("Joseph"));
	}
	@Test
	void testToString() {
		SortedArrayList list = new SortedArrayList();    // checks if toString is working properly, making sure that there are no trailing or beginning zeroes.
		list.add("Robby");
		list.add("Joseph");
		list.add("Abby");
		assert(list.toString().equals("Abby Joseph Robby"));
	}
}
