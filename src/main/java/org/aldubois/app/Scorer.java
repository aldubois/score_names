package org.aldubois.app;

public class Scorer {
	
	public static int[] score(String[] names) {
		int[] res = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			// Multiply the sum of letter score to the name position indexed at 1
			res[i] = _score_name(names[i].toCharArray()) * (i + 1);
		}
		return res;
	}
	
	private static int _score_name(char[] name) {
		int score = 0;
		for (int i = 0; i < name.length; i++) {
			// Subtract the ASCII value of the letter
			// by the ASCII value of A and add 1
			// to get A -> 1, B -> 2 ... Z -> 26
			score += name[i] - 'A' + 1;
		}
		return score;
	}
}
