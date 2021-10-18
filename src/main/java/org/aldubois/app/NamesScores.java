package org.aldubois.app;

import java.io.IOException;

import org.aldubois.app.Reader;
import org.aldubois.app.Sorter;
import org.aldubois.app.Scorer;
import org.aldubois.app.Printer;

class NamesScores {
    
   public static void main (String[] args) throws IOException {

       String[] names = Reader.read(System.in);
       Sorter.sort(names);
       int[] scores = Scorer.score(names);
       Printer.print(names, scores, System.out);
   }

}
