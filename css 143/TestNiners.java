import java.io.*;
import java.util.*;
public class TestNiners {
    public static void main(String[] args) {
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
            switch (numLines % 1000) {
                case 0: 
                    System.out.print("\rProcessing.");
                    break;
                case 250:
                    System.out.print("\rProcessing.."); 
                    break;
                case 500:
                    System.out.print("\rProcessing...");
                    break;
                case 750:
                    System.out.print("\rProcessing....");
                    break;
            }

            checkNum = Integer.parseInt(fin.nextLine());
            isNiner = niner(checkNum);
            if (isNiner) {
                fout.println("Number " + checkNum + " is multiple of 9: " + isNiner);
            }
            

        } while (fin.hasNextLine());






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