import java.util.*;
import java.io.*;
public class FractionsV1 {

    private static int usedIndices;
    private static int[][] fractions;
    // private static int numerator = 0, denominator = 0;

    public static void main(String[] args) {
        Scanner filein = makeFileScanner();
        
        createArray(countFractions());
        System.out.println("array length: " + fractions.length);

        do {
            String fraction = filein.nextLine();
            addFraction(fraction);
        } while (filein.hasNextLine());










        filein.close();
    }

    public static void createArray(int indices) {
        fractions = new int[indices][2];
    }

    public static int countFractions() {
        Scanner sc = makeFileScanner();
        int indices = 0;
        do {
            indices++;
            sc.nextLine();
        } while (sc.hasNextLine());
        sc.close();
        return indices;
    }

    public static Scanner makeFileScanner() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("fractions.txt"));
        } catch (IOException e) {
            System.err.println("File not found");
            System.exit(0);
        }
        return sc;
    }

    public static void addFraction(String fraction) {
        String[] arr = fraction.split("/");
        if (arr[1].equals("0")) {
            System.err.println("Denominator is 0, skipping");
            return;
        }
        for (int i = 0; i < 2; i++) {
            fractions[usedIndices][0] = Integer.parseInt(arr[0]);
            fractions[usedIndices][1] = Integer.parseInt(arr[1]);
        }
        usedIndices++;
    }

    /**
     * PRE: N/A
     * @param numerator
     * @param denominator
     * @return Greatest Common Denominator between two numbers
     */
    public static int euclidianAlgorithm(int numerator, int denominator) {
        int remainder = 0, GCD = 1;

        // switch if numerator less than denominator, as a needs to be larger than b for algorithm
        if (numerator < denominator) {
            int temp = numerator;
            numerator = denominator;
            denominator = temp;
        }

        do {
            remainder = numerator % denominator; // r = a % b
            numerator = denominator; // replace a with b
            denominator = remainder; // replace b with r
        } while (remainder != 0);
        
        GCD = numerator; // GCD would be the last denominator in sequence, which is now stored in numerator
        // could've kept it in denominator but would've needed unnecessary break

        return GCD;
    }
}
