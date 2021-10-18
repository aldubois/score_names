package org.aldubois.app;


import java.util.Scanner;
import java.io.InputStream;
import org.aldubois.app.IncorrectStdinException;

public class Reader {

    /**
     * Reading of a single line input stream and
     * returns the array of words contained inside.
     *
     * @param Input stream to process.
     * @return The array of words in the input stream.
     */
    public static String[] read(InputStream input_stream) {

	String input = _read_in(input_stream);
	String[] words = input.split(",");
	String[] result = new String[words.length];
	
	for (int i_word = 0; i_word < words.length; i_word++) {
	    
	    String word = words[i_word].trim();
	    if (word.length() == 0) {
		result[i_word] = word;
	    } else {
		_verify_word(i_word, word);
		result[i_word] = word.substring(1, word.length() - 1);
	    }
	}

	return result;
    }

    
    /**
     * Reading of a single line input stream and
     * throw errors for other kind of input stream.
     *
     * @param Input stream to process.
     * @return the standard input in a String.
     */
    private static String _read_in(InputStream input_stream) {
	
	Scanner scanner = new Scanner(input_stream);
	
	if (!scanner.hasNextLine()) {
	    throw new IncorrectStdinException("Empty Standard Input!");
	}
	
	String input = scanner.nextLine();
	
	if (scanner.hasNextLine()) {
	    throw new IncorrectStdinException("Standard Input must have a single line!");
	}
	
	return input;
    }

    private static void _verify_word(int i_word, String word) {

	int word_size = word.length();
	if (word_size == 1) {
	    throw new IncorrectStdinException("The word " + word +
					      " at position " + i_word +
					      " is incorrect!");
	}
	// Verify that the word is surrounded by double quote.
	else if(word.charAt(0) != '"' || word.charAt(word_size - 1) != '"') {
	    
	    throw new IncorrectStdinException("The word " + word +
					      " at position " + i_word +
					      " should be between double quotes!");
		
	} else {
	    // Verify that the word is composed of only caps letters.
	    for (int i_letter = 1; i_letter < word_size - 1; i_letter++) {
		
		char letter = word.charAt(i_letter);
		
		if (letter < 'A' || letter > 'Z') {
		    throw new IncorrectStdinException("The word " + word +
						      " at position " + i_word +
						      " should be composed of caps letters!");
		}
	    }
	}	
    }
}
