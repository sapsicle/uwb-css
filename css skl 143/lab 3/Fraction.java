public class Fraction {
    /* invariants
     * numerator and denominator are final
     * no 0 denominator
     * always stored in reduced form
     */

    public final int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        int gcd = GCD(numerator, denominator);                                                                      // find GCD to reduce fraction to lowest terms
        this.numerator = numerator / gcd;                                                                           // store lowest terms of num and den
        this.denominator = denominator / gcd;
    }

    public Fraction(Fraction other) {
        int gcd = GCD(other.numerator, other.denominator);                                                          // find GCD to reduce fraction to lowest terms
        this.numerator = other.numerator / gcd;                                                                     // store lowest terms of num and den
        this.denominator = other.denominator / gcd;
    }

    public int getNum() {
        return this.numerator;
    }

    public int getDenom() {
        return this.denominator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Fraction) || object == null)
            return false;
        Fraction other = (Fraction) object;
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    public Fraction add(Fraction other) {
        // see https://tinyurl.com/3w2bn2yk for reference on logistics

        int lcm = LCM(this.denominator, other.denominator);                                                         // lowest common multiple to bring denominators to same terms
        // denominators become LCM
        // num1 = numerator of "this" fraction, num2 = numerator of "other" fraction
        int num1 = (lcm / this.denominator) * this.numerator;                                                       // numerators are multiplied by whatever factor their denominator needed to reach LCM, factor being LCM / Denominator
        int num2 = (lcm / other.denominator) * other.numerator;

        int num = num1 + num2, den = lcm;                                                                           // now in same terms, add numerators, denominator is the LCM
        int gcd = GCD(num, den);                                                                                    // find GCD for simplifying
        num /= gcd;                                                                                                 // reduce terms by GCD
        den /= gcd;

        return new Fraction(num, den);                                                                              // return new fraction object to avoid privacy leaks
    }

    /**
     * Euclidian algorithm for finding GCD between 2 numbers, reused from FractionsV1
     * @param a 
     * @param b 
     * @return Greatest Common Denominator (GCD)
     */
    public static int GCD(int a, int b) {
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
            a = b;                                                                                                  // replace a with b
            b = r;                                                                                                  // replace b with r
        } while (r != 0);                                                                                           // loop until finished with a remainder of 0
        
        /* 
         * GCD would be the last b in sequence, which is now stored in a after loop finishes
         * Could've kept it in b for logical sense in reading but would've needed unnecessary break
         */
        GCD = a; 

        return GCD;
    }

    /**
     * Algorithm for finding the Lowest Common Multiple (LCM) for two numbers which is their product divided by their Greatest Common Denominator (GCD)
     * @param a First number
     * @param b Second Number
     * @return Lowest Common Multiple (LCM)
     */
    private static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
}