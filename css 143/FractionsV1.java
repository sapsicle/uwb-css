/*
 * 1. Yes, but you'd need maybe 4-5 variables per fraction
 * 2. Probably yes as an int array, but I found it easier to re-stringify the fractions for comparisons to avoid any mistakes in float math
 * 3. An inner class is a class only accessible by the outer class
 * 4. Dividing the fractions outright into decimals and then comparing, though susceptible to float math mistakes
 */

import java.util.*;
import java.io.*;
public class FractionsV1 {

    private static int usedIndices;
    private static int[][] fractions;
    private static String[] uniqueFracs;
    private static int[] uniqueCount;
    private static String[] simpFracStr;
    private static int uniques = 0;
    // private static int numerator = 0, denominator = 0;

    public static void main(String[] args) {
        Scanner filein = makeFileScanner();
        
        createArray(countFractions());
        // System.out.println("array length: " + fractions.length);

        /* 
         * uniqueFracs[n] stores the Nth given unique fraction
         * uniqueCount[n] increments with each appearance of Nth unique fraction, counting them
         */
        uniqueFracs = new String[fractions.length];
        uniqueCount = new int[uniqueFracs.length];
        for (int i = 0; i < uniqueCount.length; i++) {
            uniqueCount[i] = 0;
        }

        // Take each fraction sequentially, de-string, and store in fractions[][]
        do {
            String fraction = filein.nextLine();
            addFraction(fraction);
        } while (filein.hasNextLine());

        
        simplify();             // Simplifies the global fractions[][] array

        getStringArr();         // Stringifies the fractions after simplifying

        compareCount();         // Updates and compares against an array tracking unique fractions

        

        for (int i = 0; i < uniques; i++) {
            System.out.println(uniqueFracs[i] + " has a count of: " + uniqueCount[i]);
        }








        filein.close();
    }

    /**
     * Array creation, method allows for self-containment if needed
     * @param indices
     */
    public static void createArray(int indices) {
        fractions = new int[indices][2];
    }

    /**
     * Counts the number of fractions in the file
     * PRE: Each fraction is separated on its own line
     * POST: Number of lines and therefore fractions determined for array creation
     * @return Numer of fractions contained in the file
     */
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

    /**
     * Separate method for Scanner FileInputStream if reuse needed
     * @return Scanner FileInputStream object
     */
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

    /**
     * Method to de-string the fractions passed in individually from the file
     * Parses ints and store the numerator of Nth given fraction in arr[n][0] and the denominator in arr[n][1]
     * @param fraction
     */
    public static void addFraction(String fraction) {
        /* 
         * Separate numerator and denominator into separate strings over regex '/' as all fractions will have values separated by slash
         * Numerator in arr[0] and denominator in arr[1]
         */
        String[] arr = fraction.split("/");
        
        // Preventing divide by 0 by skipping entirely
        if (arr[1].equals("0")) {
            System.err.println("Denominator is 0, skipping");
            return;
        }

        // Store parsed ints in fractions array at given global index
        for (int i = 0; i < 2; i++) {
            fractions[usedIndices][0] = Integer.parseInt(arr[0]);
            fractions[usedIndices][1] = Integer.parseInt(arr[1]);
        }
        usedIndices++;
    }

    /**
     * Euclidian algorithm for determining greatest common denominator between 2 numbers, in this context the numerator and denominator for reduction
     * @param numerator
     * @param denominator
     * @return Greatest Common Denominator between two numbers
     */
    public static int euclidianAlgorithm(int numerator, int denominator) {
        int remainder = 0, GCD = 1;

        // switch if numerator less than denominator, as 'a' needs to be larger than 'b' for algorithm
        if (numerator < denominator) {
            int temp = numerator;
            numerator = denominator;
            denominator = temp;
        }

        // Actual algorithm, numerator referred to as 'a' and denominator referred to as 'b'
        do {
            remainder = numerator % denominator;        // r = a % b
            numerator = denominator;                    // replace a with b
            denominator = remainder;                    // replace b with r
        } while (remainder != 0);                       // loop until finished with a remainder of 0
        
        /* 
         * GCD would be the last denominator in sequence, which is now stored in numerator after loop finishes
         * Could've kept it in denominator for logical sense in reading but would've needed unnecessary break
         */
        GCD = numerator; 

        return GCD;
    }

    /**
     * Simplifies all fractions in fractions[][]
     */
    public static void simplify() {
        int GCD;
        for (int i = 0; i < fractions.length; i++) {
            GCD = euclidianAlgorithm(fractions[i][0], fractions[i][1]);     // Find GCD between each numerator and denominator pair
            fractions[i][0] /= GCD;                                         // Simplify numerator and store in same location
            fractions[i][1] /= GCD;                                         // Simplify denominator and store in same location
        }
    }

    /**
     * Sends simplified fractions to string array for easy comparison and counts
     */
    public static void getStringArr() {
        simpFracStr = new String[fractions.length];

        for (int i = 0; i < fractions.length; i++) {
            simpFracStr[i] = Integer.toString(fractions[i][0]) + "/" + Integer.toString(fractions[i][1]);
        }
    }

    public static void compareCount() {
        
        uniqueFracs[0] = simpFracStr[0];                            // Guaranteed unique fraction
        // uniqueCount[0] = 1;                             // Increment count for 0th unique fraction
        uniques = 1;                                                // Number of unique fractions increments
        
        for (int i = 0; i < simpFracStr.length; i++) {
            boolean beenPlaced = false;
            // String str = simpFracStr[i];
            for (int j = 0; j < uniques; j++) {                     // Loop over array of uniques, only as many places as are used (# of uniques)
                if (simpFracStr[i].equals(uniqueFracs[j])) {        // If the simplified fraction has already been logged in the array as existing
                    uniqueCount[j]++;                               // Increment count for given fraction
                    beenPlaced = true;                              // Bool flag for if the fraction exists in the array
                    break;                                          // Terminate inner loop and move to next fraction
                }
            }

            if (beenPlaced == false) {                              // If the fraction did not already exist in the array
                uniqueFracs[uniques] = simpFracStr[i];              // Add fraction as new unique at working end of array
                uniqueCount[uniques]++;                             // Add 1 to the count for that fraction
                uniques++;                                          // Increase count of uniques
            }
        }
    }
}