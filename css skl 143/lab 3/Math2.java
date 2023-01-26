public class Math2 {
    // all must be static

    public static final double PI = 3.14159265358979323846264338327950288419716939937510;
    public static final double E = 2.7182818284590452353602874713527;

    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static double max(double a, double b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static int pow(int base, int exp) {
        if (exp == 0)
            return 1;                                                                                               // any number to 0th power is 1
        int foo = 1;                                                                                                // initialize to 1 to multiply base in
        for (int i = 0; i < exp; i++)
            foo *= base;                                                                                            // multiply base exp number of times
        return foo;
    }
}