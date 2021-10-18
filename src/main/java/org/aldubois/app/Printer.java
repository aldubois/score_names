package org.aldubois.app;

import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.aldubois.app.PrinterException;

public class Printer {

    /**
     * Write the scores of the names in the given output stream.
     * 
     * @param Names that were scored.
     * @param Scores of those names.
     * @param Output stream to write in.
     */
    public static void print(String[] names, int[] scores, OutputStream output_stream) throws IOException, UnsupportedEncodingException {

	if (names.length != scores.length) {
	    String msg = "Names array and scores array should be of same length ";
	    msg += names.length + " != " + scores.length + " !";
	    throw new PrinterException(msg);
	} else {
	    Writer writer = new OutputStreamWriter(output_stream, "UTF-8");
	    int sum = 0;
	    for (int idx = 0; idx < names.length; idx++) {
		writer.write(names[idx] + "," + scores[idx] + "\n");
		sum += scores[idx];
	    }
	    writer.write("Sum," + sum + "\n");
	    writer.close();
	}
    }
}
