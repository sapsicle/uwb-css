
// //necessary imports for file i/o
// import java.io.FileInputStream; //"turns" the file into a read stream
// import java.util.Scanner; //reads from stream
// import java.io.IOException;
// import java.io.File;
// import java.io.FileOutputStream; //"turns" the file into a write stream
// import java.io.PrintWriter; //writes to the stream

// import java.io.FileNotFoundException; //this exception must be caught and handled when dealing with streams!

import java.io.*;
import java.util.*;

/**
 * Write a description of class Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stats {
    public static void main(String[] args) throws IOException{  
        // Scanner and PrintWrite must be declared outside the try block
        // otherwise their scope will be limited to within the block 
        Scanner input = null;
        
        double inputNumber = 0.0;
        
        int negNum = 0;
        int btw0and100 = 0;
        int geq100 = 0;
        
        int lineCounter = 0;
        double grandTotal = 0.0;
        
        double min = 0.0;
        double max = 0.0;
        double average = 0.0;
        
        try {            
           input = new Scanner(new FileInputStream("fileIn.txt"));
           
        } 
        catch (IOException e) {
           System.out.println("File not found.");
           System.exit(0);
        }

        while (input.hasNextLine()) {
            inputNumber = input.nextDouble();
            grandTotal += inputNumber;
            lineCounter++;
            
            if (inputNumber < 0) {
                negNum++;
            }
            
            if (inputNumber >= 0 && inputNumber < 100) {
                btw0and100++;
            }

            if (inputNumber >= 100) {
                geq100++;
            }

            if (inputNumber > max) {
                max = inputNumber;
            }
            else if (inputNumber < min) {
                min = inputNumber;
            }
        }

        average = grandTotal / lineCounter;






 
        input.close();   
        display(average, max, min, negNum, btw0and100, geq100);
    }

    public static void display(double average, double max, double min, int negNum, int btw0and100, int geq100){
    
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileOutputStream("fileOut.txt"));
                
        } catch (IOException e) {
            System.out.println(" Sorry, we cannot locate the file!");
            System.exit(0);
        }

        output.println("Statistics for the numbers in fileIn.txt:");
        output.println("average: " + average);
        output.println("max: " + max);
        output.println("min: " + min + "\n");

        output.println("There are " + negNum + " negative numbers, " + btw0and100 + " numbers between 0 (inclusive) and 100 (exclusive), and " + geq100 + " numbers that are greater than or equal to 100.");



        output.close();
    }
}
