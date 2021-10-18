package org.aldubois.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import org.aldubois.app.Reader;
import org.aldubois.app.IncorrectStdinException;


public class ReaderTest {

    @Test
    public void test_empty_input() {
	// Test sorting of an empty array
	String input = "";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	Exception exc = assertThrows(IncorrectStdinException.class,
				     () -> { Reader.read(stream); });
	
	String ref_msg = "Empty Standard Input!";
	String calc_msg = exc.getMessage();
	
	assertEquals(ref_msg, calc_msg);
    }
	
    @Test
    public void test_empty_one_line_input() {
	// Test sorting of an empty array
	String input = "\n";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	String[] result = Reader.read(stream);
	assertEquals(result.length, 1);
	assertEquals(result[0], "");
    }

    @Test
    public void test_multiple_lines_input() {
	// Test sorting of an empty array
	String input = "\"BOB\"\n\"BERTIE\"";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	Exception exc = assertThrows(IncorrectStdinException.class,
				     () -> { Reader.read(stream); });
	
	String ref_msg = "Standard Input must have a single line!";
	String calc_msg = exc.getMessage();
	
	assertEquals(ref_msg, calc_msg);
    }
	
    @Test
    public void test_valid_input_no_spaces() {
	// Test sorting of an empty array
	String input = "\"BOB\",\"BERTIE\"";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	String[] ref = {"BOB", "BERTIE"};
	String[] calc = Reader.read(stream);
	assertArrayEquals(ref, calc);
    }

    @Test
    public void test_valid_input_with_spaces() {
	// Test sorting of an empty array
	String input = "\"BOB\",   \"BERTIE\",\"BERNARD\"";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	String[] ref = {"BOB", "BERTIE", "BERNARD"};
	String[] calc = Reader.read(stream);
	assertArrayEquals(ref, calc);
    }

    @Test
    public void test_valid_input_with_empty_name() {
	// Test sorting of an empty array
	String input = "\"BOB\",   \"BERTIE\",\"\",\"BERNARD\"";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	String[] ref = {"BOB", "BERTIE", "", "BERNARD"};
	String[] calc = Reader.read(stream);
	assertArrayEquals(ref, calc);
    }

    @Test
    public void test_no_quotes_input() {
	// Test sorting of an empty array
	String input = "\"BOB\",BERTIE";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	Exception exc = assertThrows(IncorrectStdinException.class,
				     () -> { Reader.read(stream); });
	
	String ref_msg = "The word BERTIE at position 1 should be between double quotes!";
	String calc_msg = exc.getMessage();
	
	assertEquals(ref_msg, calc_msg);
    }

    @Test
    public void test_lowercase_input() {
	// Test sorting of an empty array
	String input = "\"BoB\",BERTIE";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	Exception exc = assertThrows(IncorrectStdinException.class,
				     () -> { Reader.read(stream); });
	
	String ref_msg = "The word \"BoB\" at position 0 should be composed of caps letters!";
	String calc_msg = exc.getMessage();
	
	assertEquals(ref_msg, calc_msg);
    }

    @Test
    public void test_one_letter_in_word_input() {
	// Test sorting of an empty array
	String input = "\"BOB\",\"BERTIE\",C";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	Exception exc = assertThrows(IncorrectStdinException.class,
				     () -> { Reader.read(stream); });
	
	String ref_msg = "The word C at position 2 is incorrect!";
	String calc_msg = exc.getMessage();
	
	assertEquals(ref_msg, calc_msg);
    }

    @Test
    public void test_special_char_in_word_input() {
	// Test sorting of an empty array
	String input = "\"BOB\",\"BERTIE\",\"BERN@RD\"";
	InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	Exception exc = assertThrows(IncorrectStdinException.class,
				     () -> { Reader.read(stream); });
	
	String ref_msg = "The word \"BERN@RD\" at position 2 should be composed of caps letters!";
	String calc_msg = exc.getMessage();
	
	assertEquals(ref_msg, calc_msg);
    }
}
