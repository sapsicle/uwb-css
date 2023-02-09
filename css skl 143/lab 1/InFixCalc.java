import java.util.*; 
/*
 * InFixCalc, V0.0 (concept borrowed from Carol Zander's Infix Calculator)
 * Exercise author: Rob Nash
 * Complete the calculate() function below to build a simple, infix
 * calculator that evaluates a compound expression from left to right,
 * regardless of operator precedence
 *
 * Example: " 1 * -3 + 6 / 3"
 * Execution: calculate 1 * -3 first, then -3 + 6 next, then 3 / 3
 * last to obtain the value 1
*
* Solution by 
*/
public class InFixCalc {
    //example pattern: "3 + 5"
    //general pattern: <lhs='3'> <operation='+'> <rhs='5'> //extended pattern:     ...  
    //special case: 
    //other special cases?

    public static void main(String[] args) { 
        Scanner kb = new Scanner(System.in);
        //String input = "4 + 4";
        //String input = "4 + 4 / 2";
        //String input ="1 * -3";
        String input = kb.nextLine();
        String[] arr = input.split(" ");
        //String input ="5";
        //String input ="-5";
        int answer = calculate(arr);
        System.out.println("Answer is " + answer);
    }

    //preconditions: all binary operations are separated via a space
    //postconditions: returns the result of the processed string
    private static int calculate(String[] input) {
        // int lhs = 0;                                            //short for left-hand side
        // int rhs = 0;                                            //short for right-hand side
        // char operation;

        int[] nums = parseInts(input);
        String[] ops = getOps(input);

        int solution = nums[0];
        for (int i = 0; i < ops.length; i++) {
            String var = ops[i];
            switch (var) {
                case "+":
                    solution += nums[i + 1];
                    break;
                case "-":
                    solution -= nums[i + 1];
                    break;
                case "*":
                    solution *= nums[i + 1];
                    break;
                case "/":
                    solution /= nums[i + 1];
                    break;
            }
        }

        // can't figure out why but it's ignoring the last
        return solution;
    }

    private static int[] parseInts(String[] input) {
        double arrLength = (input.length / 2) + 0.5;            // array of nums and ops will always have an odd length, number of nums is 1 more than ops
        int[] nums = new int[(int)arrLength];                   // array to parse ints into will have length calculated above casted into int
     
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[2 * i]);           // fill each num index with an int which will be at every other input index starting at 0
        }

        return nums;
    }

    private static String[] getOps(String[] input) {
        double arrLength = (input.length / 2) - 0.5;            // number of ops 1 less than nums
        String[] ops = new String[(int)arrLength];              // array with length of number of ops

        for (int i = 0; i < ops.length; i++) {
            ops[i] = input[(2 * i) + 1];                        // pull ops into array, every other starting on 1
        }

        return ops;
    }
}