import java.util.*;
import java.io.*;
public class FractionsV1 {

    private static int usedIndices;
    private static int[][] fractions;
    private static int numerator = 0, denominator = 0;

    public static void main(String[] args) {
        Scanner filein = null;
        try {
            filein = new Scanner(new FileInputStream("fractions.txt"));
        } catch (IOException e) {
            System.err.println("File not found");
            System.exit(0);
        }
        
        createArray(countFractions(filein));
        System.out.println("array length: " + fractions.length);

        do {
            String fraction = filein.nextLine();
            addFraction(fraction);
        } while (filein.hasNextLine());

        // System.out.println("number of fractions: " + usedIndices);
        // System.out.println("fraction #17: " + fractions[16][0] + "/" + fractions[16][1]);


        




        // System.out.println("numerator: " + num + ", denominator: " + den);








        filein.close();
    }

    public static void createArray(int indices) {
        fractions = new int[indices][2];
    }

    public static int countFractions(Scanner sc) {
        int indices = 0;
        do {
            indices++;
        } while (sc.hasNextLine());
        return indices;
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
}
