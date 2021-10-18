package org.aldubois.app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import org.aldubois.app.Printer;
import org.aldubois.app.PrinterException;


class PrinterTest {

    @Test
    void test_score_empty() throws java.io.IOException {
	// Test sorting of an empty array
	String[] names = new String[0];
	int[] scores = new int[0];
	String ref = "Sum,0\n";
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	Printer.print(names, scores, os);
	String calc = new String(os.toByteArray());
	assertEquals(ref, calc);
    }

    @Test
    void test_score_main_case() throws java.io.IOException {
	// Test sorting of an empty array
	String[] names = {"ZOE", "", "BILL", "RICHARD"};
	int[] scores = {
	    1 * (26 + 15 + 5),
	    2 * 0,
	    3 * (2 + 9 + 12 + 12),
	    4 * (18 + 9 + 3 + 8 + 1 + 18 + 4)
	};
	String ref = "ZOE,46\n,0\nBILL,105\nRICHARD,244\nSum,395\n";
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	Printer.print(names, scores, os);
	String calc = new String(os.toByteArray());
	assertEquals(ref, calc);
    }

    @Test
    void test_size_mismatch() throws java.io.IOException {
	// Test sorting of an empty array
	String[] names = {"BOB"};
	int[] scores = {35, 48};
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	Exception exc = assertThrows(PrinterException.class,
				     () -> { Printer.print(names, scores, os);; });
    }
}
