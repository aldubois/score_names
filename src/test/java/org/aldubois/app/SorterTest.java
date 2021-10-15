package org.aldubois.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import org.aldubois.app.Sorter;


public class SorterTest {

	@Test
	public void test_empty_array() {
		// Test sorting of an empty array
		String[] names = new String[0];
		String[] ref = new String[0];
		Sorter.sort(names);
		assertArrayEquals(names, ref);
	}
	
	@Test
	public void test_unit_array() {
		// Test sorting of an array with a non-empty string single element.
		String[] names = {"ALEX"};
		String[] ref = {"ALEX"};
		Sorter.sort(names);
		assertArrayEquals(names, ref);
	}
	
	@Test
	public void test_unit_array_empty() {
		// Test sorting of an array with a non-empty string single element.
		String[] names = {""};
		String[] ref = {""};
		Sorter.sort(names);
		assertArrayEquals(names, ref);
	}

	@Test
	public void test_array_even() {
		// Test sorting with a power of 2 length of array
		String[] names = {"ZOE", "BOB", "", "MIKE"};
		String[] ref = {"", "BOB", "MIKE", "ZOE"};
		Sorter.sort(names);
		assertArrayEquals(names, ref);
	}

	@Test
	public void test_array_odd() {
		// Test sorting with a non power of 2 length of array
		String[] names = {"ZOE", "BOB", "", "MIKE", "ZACHARY"};
		String[] ref = {"", "BOB", "MIKE", "ZACHARY", "ZOE"};
		Sorter.sort(names);
		assertArrayEquals(names, ref);
	}
}
