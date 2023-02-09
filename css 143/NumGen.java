import java.io.*;
import java.util.*;
public class NumGen {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String fileName = "numbers.txt";
        PrintWriter fout = null;
        try {
            fout = new PrintWriter(new FileOutputStream(fileName, true));
        } catch (IOException e) {
            System.err.println("Could not find or create file");
            System.exit(0);
        }

        int lines = 100_000_000, range = 100_000_000;                                                               // number of lines and what range to gen numbers

        System.out.println("Writing ints to file: " + fileName);
        Random rand = new Random();
        for (int i = 0; i < lines; i++) {
            fout.println(rand.nextInt(range));
            System.out.print("\rProgress: " + (i + 1) + "/" + lines);
        }
        System.out.println(/* end line */);

        System.out.println("Done! Took " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }
}