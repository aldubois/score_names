package org.aldubois.app;

public class Sorter {
	
	/**
	 * In place sorting of the array of string given as argument.
	 * 
	 * @param names Array of names to be sorted (modified in-place).
	 */
	public static void sort(String[] names) throws IllegalArgumentException {
		// Public sort method calling the underlying merge-sort algorithm.
		// or leave the list untouched if empty or with only one element.
		if (names.length > 1) {
			_sort(names, 0, names.length - 1);				
		}
	}
	
	private static void _sort(String[] names, int left, int right) throws IllegalArgumentException {
		
		if (left < right) {
			// Split the array in two, recursively call merge sort
			// for both array and then merge back the two arrays
			int mid = left + (right - left) / 2;
			_sort(names, left, mid);
			_sort(names, mid + 1, right);
			_merge(names, left, mid, right);
		}
		else if (right < left) {
			throw new IllegalArgumentException("Right index " + right + " is inferior to left index " + left + " !");
		}
	}
	
	private static void _merge(String[] names, int left, int mid, int right) {
		
		int size_left = mid - left + 1;
		int size_right = right - mid;
		
		// Temporary copy of the half arrays that are already sorted
		String[] names_left = new String[size_left];
		System.arraycopy(names, left, names_left, 0, size_left);
		String[] names_right = new String[size_right];
		System.arraycopy(names, mid + 1, names_right, 0, size_right);
	
		int idx_left = 0;
		int idx_right = 0;
		int idx = left;
		
		// Add the smallest element of both temporary array at their current index,
		// populate the main array with that value at the main idx 
		// and increment the idx of the corresponding half array and of the main array.
		while (idx_left < size_left && idx_right < size_right) {
			if (names_left[idx_left].compareTo(names_right[idx_right]) <= 0) {
				names[idx] = names_left[idx_left];
				idx_left++;
			} else {
				names[idx] = names_right[idx_right];
				idx_right++;
			}
			idx++;
		}
		
		// Finish adding the remaining values (from either the left or the right rarry
		while (idx_left < size_left) {
			names[idx] = names_left[idx_left];
			idx_left++;
			idx++;
		}
		while (idx_right < size_right) {
			names[idx] = names_right[idx_right];
			idx_right++;
			idx++;
		}
	}
}
