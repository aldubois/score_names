package org.aldubois.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import org.aldubois.app.Scorer;

class ScorerTest {

    @Test
    void test_score_empty() {
	// Test sorting of an empty array
	String[] names = new String[0];
	int[] ref = new int[0];
	int[] calc = Scorer.score(names);
	assertArrayEquals(calc, ref);
    }

    @Test
    void test_score_one_name() {
	// Test sorting of an array with one name
	String[] names = {"BOB"};
	int[] ref = {1 * (2 + 15 + 2)};
	int[] calc = Scorer.score(names);
	assertArrayEquals(calc, ref);
    }
    
    @Test
    void test_score_multiple_names() {
	// Test sorting of an array with multiple name
	String[] names = {"ZOE", "", "BILL", "RICHARD"};
	int[] ref = {
	    1 * (26 + 15 + 5),
	    2 * 0,
	    3 * (2 + 9 + 12 + 12),
	    4 * (18 + 9 + 3 + 8 + 1 + 18 + 4)
	};
	int[] calc = Scorer.score(names);
	assertArrayEquals(calc, ref);
    }
}
