import java.io.*;
import java.util.*;
public class NumGen {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        PrintWriter fout = null;
        try {
            fout = new PrintWriter(new FileOutputStream(fileName, true));
        } catch (IOException e) {
            System.err.println("Could not find or create file");
            System.exit(0);
        }

        int lines = 100_000_000;
        System.out.println("Writing ints to file " + fileName);
        Random rand = new Random();
        for (int i = 0; i < lines; i++) {
            fout.println(rand.nextInt(lines));
            System.out.print("\rProgress: " + (i + 1) + "/" + lines);
        }
    }
}
