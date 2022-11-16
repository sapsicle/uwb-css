import java.util.*;
/**
 * This program will get a line of input from the user
 * and will print a copy of the line in which the first
 * character of each word has been changed to upper case.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lab7 {
    public static void main(String[] args) {


        capitalizeFirstLetters("I really enjoy attending lab!");
    }

    // Print a copy of str to standard output, with the
    // first letter of each word in upper case
    static void capitalizeFirstLetters(String str) {
        String[] sentence = str.split(" ");
        for (String word : sentence) {
            Character.toUpperCase(word.charAt(0));
            System.out.print(word + " ");
        }
        System.out.println();
        
        // String[] sentence = str.split(" ", 0);
        // Scanner in = new Scanner(str);
        // String word;
        // do {
        //     word = in.next();
        //     Character.toUpperCase(word.charAt(0));
        //     System.out.print(word + " ");
        // } while (in.hasNext());
        // System.out.println(); //newline
        // // Your logic goes here
        // in.close();
    }

}  // end class
