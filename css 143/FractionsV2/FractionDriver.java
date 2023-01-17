import java.util.*;
import java.io.*;
public class FractionDriver {
    public static void main(String[] args) {
        ArrayList<FractionCounter> fracCounts = new ArrayList<>();
        
        Scanner fin = null;
        try {
            fin = new Scanner(new FileInputStream("fractions.txt"));
        } catch (IOException e) {
            System.err.println("File not found");
            System.exit(0);
        }

        fracCounts.add(new FractionCounter(getNextFraction(fin)));                                                  // first fraction, obviously unique

        do {
            boolean isUnique = true;                                                                                // bool checker, flips if fraction exists in list
            Fraction tempFrac = getNextFraction(fin);                                                               // create fraction object to compare against list
            
            for (int i = 0; i < fracCounts.size(); i++) {                                                           // loop over list, comparing new fraction to existing uniques
                if (fracCounts.get(i).compare(tempFrac)) {                                                          // if comparison returns true
                    fracCounts.get(i).increment();                                                                  // increase count for fraction
                    isUnique = false;                                                                               // flip bool checker to prevent duplicate added into list
                }
            }
            
            if (isUnique) {                                                                                         // if fraction does not exist in list
                fracCounts.add(new FractionCounter(tempFrac));                                                      // add fraction to list as unique, count automatically constructs to 1
            }
        } while (fin.hasNextLine());                                                                                // loops until out of fractions in file


        for (FractionCounter var : fracCounts) {
            System.out.println(var.toString());                                                                     // prints fraction and count
        }
        





    }

    

    /**
     * Method for getting the next fraction out of the file, parsing the numerator and denominator, and setting the Fraction object values
     * @param fin Scanner to read file
     * @return Fraction object with set values
     */
    private static Fraction getNextFraction(Scanner fin) {
        Fraction frac = new Fraction();

        String temp = fin.nextLine();
        String[] strArr = temp.split("/");

        frac.setNumerator(Integer.parseInt(strArr[0]));                                                             // set numerator
        if (Integer.parseInt(strArr[1]) != 0) {                                                                     // check if denominator is 0
            frac.setDenominator(Integer.parseInt(strArr[1]));                                                       // set if not 0
        } else {                                                                                                    // if denominator 0, div by 0 error invalid fraction
            System.err.println("0 denominator, setting fraction to 1/1");                                           // replace fraction with 1/1
            frac.setNumerator(1);                                                                                   // set numerator to 1
            frac.setDenominator(1);                                                                                 // set denominator to 1

        }

        if (frac.getNumerator() < 0 && frac.getDenominator() < 0) {                                                 // if numerator and denominator are both negative
            frac.setNumerator(Math.abs(frac.getNumerator()));                                                       // terms cancel, set num to positive
            frac.setDenominator(Math.abs(frac.getDenominator()));                                                   // set den to positive
        }

        int GCD = euclidianAlgorithm(frac.getNumerator(), frac.getDenominator());                                   // get GCD for terms
        frac.setNumerator(frac.getNumerator() / GCD);                                                               // set numerator to lowest term
        frac.setDenominator(frac.getDenominator() / GCD);                                                           // set denominator to lowest term

        return frac;                                                                                                // return fraction when done setting values
    }

    /**
     * Euclidian algorithm for finding GCD between 2 numbers, reused from FractionsV1
     * @param a 
     * @param b 
     * @return Greatest Common Denominator (GCD)
     */
    public static int euclidianAlgorithm(int a, int b) {
        int r = 0, GCD = 1;

        // switch if needed, as 'a' needs to be larger than 'b' for algorithm
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Actual algorithm
        do {
            r = a % b;
            a = b;                                                                      // replace a with b
            b = r;                                                                      // replace b with r
        } while (r != 0);                                                               // loop until finished with a remainder of 0
        
        /* 
         * GCD would be the last b in sequence, which is now stored in a after loop finishes
         * Could've kept it in b for logical sense in reading but would've needed unnecessary break
         */
        GCD = a; 

        return GCD;
    }
}
