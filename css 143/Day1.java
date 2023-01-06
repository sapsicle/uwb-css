import java.util.*;
import java.io.*;
public class Day1 {
    public static void main(String[] args) {
        // askName();
        // readFile();
        // helloWorld();

        


    }

    public static void helloWorld() {
        System.out.println("Hello world");
        short a = 1, b = 2, c = 3, d = 4;
        int add = a + b + c + d;
        System.out.println("a + b + c + d = " + add);

        Scanner kb = new Scanner(System.in);
        System.out.print("What is your age?: ");
        short age = (short)kb.nextInt();
        System.out.print("What is your name?: ");
        String name = kb.next();
        int midPoint = (int)(name.length() / 2);
        String wackName = name.substring(midPoint - 1) + name.substring(0, midPoint);
        for (int i = 0; i < (age / 4); i++) {
            System.out.println("You were born in " + (2023 - age) + ", " + wackName);
        }

        kb.close();
    }

    public static void askName() {
        Scanner kb = new Scanner(System.in);

        System.out.print("What is your name?: ");
        String name = "";
        try {
            name = kb.next();
        } catch (InputMismatchException e) {
            System.err.println("Invalid name");
        }

        System.out.println("Hello, " + name);
        
        kb.close();
    }

    public static void readFile() {
        Scanner fin = null;
        try {
            fin = new Scanner(new FileInputStream("file.txt"));
            System.out.println(fin.nextLine());
        } catch (IOException e) {
            System.err.println("shit's fucked son");
        }

    }
}