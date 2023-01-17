// import java.util.*;
// import java.io.*;
public class FractionCounter {
    Fraction fraction;                                                                                                          // fraction object
    int count;                                                                                                                  // counter for appearances of fraction

    public FractionCounter(Fraction fraction) {
        this.fraction = fraction;                                                                                               // set fraction to count as incoming fraction
        this.count = 1;                                                                                                         // adding a fraction means there's at least 1
    }

    public boolean compare(Fraction newFrac) {
        if (this.fraction.equals(newFrac)) {                                                                                    // if incoming fraction is same as invoking
            return true;
        } else {
            return false;
        }
    }

    public void increment() {
        this.count++;                                                                                                           // add 1 to count (called if compare() returned false)
    }

    @Override
    public String toString() {
        return this.fraction.toString() + " has a count of " + this.count;                                                      // returns concantenated string displaying fraction and count
    }
}