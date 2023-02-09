import java.io.*;
import java.util.*;
public class TestNiners {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner fin = null;
        try {
            fin = new Scanner(new FileInputStream("numbers.txt"));
        } catch (IOException e) {
            System.err.println("Could not find file");
            System.exit(0);
        }

        PrintWriter fout = null;
        try {
            fout = new PrintWriter(new FileOutputStream("results.txt"));
        } catch (IOException e) {
            System.err.println("Could not find or create file");
            System.exit(0);
        }

        int numLines = 0;
        int checkNum;
        boolean isNiner;
        do {
            numLines++;
            updateProc(numLines);

            checkNum = Integer.parseInt(fin.nextLine());
            isNiner = niner(checkNum);
            if (isNiner) {
                fout.println("Number " + checkNum + " is a niner, is it a multiple of 9?: " + (checkNum % 9 == 0));
            }
        } while (fin.hasNextLine());

        System.out.println(/* end line */);

        System.out.println("Done! Took " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    public static void updateProc(int numLines) {
        switch (numLines % 1_000_000) {
            case 0: 
                System.out.print("\rProcessing...|");
                break;
            case 250_000:
                System.out.print("\rProcessing.../"); 
                break;
            case 500_000:
                System.out.print("\rProcessing...-");
                break;
            case 750_000:
                System.out.print("\rProcessing...\\");
                break;
        }
    }

    public static boolean niner(int number) {
        String foo = Integer.toString(number);
        int bar = 0;
        boolean returnVal = false;

        for (int i = 0; i < foo.length(); i++) {
            bar += Character.getNumericValue(foo.charAt(i));
        }

        if (bar == 9) {
            returnVal = true;
        } else if (bar != 9 && Integer.toString(bar).length() == 1) {
            returnVal = false;
        } else {
            returnVal = niner(bar);
            return returnVal;
        }
        
        return returnVal;                                                       // dummy return so it doesn't complain
    }
}