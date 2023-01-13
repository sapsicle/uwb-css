import java.util.*;
import java.io.*;
public class FractionDriver {
    public static void main(String[] args) {
        
    }

    /**
     * Euclidian algorithm for finding GCD, reused from FractionsV1
     * @param numerator Numerator of fraction
     * @param denominator Denominator of fraction
     * @return Greatest Common Denominator (GCD)
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
}
