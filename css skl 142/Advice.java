import java.io.*;
import java.util.*;
public class Advice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter fout = null;
        PrintWriter foutLog = null;
        

        String advice = "";
        //String currentLine = "";
        boolean looper = false, firstRun = false;
        Scanner fin = null;
        while (!looper) {
            try {
                fin = new Scanner(new FileInputStream("advice.txt"));
                break;
            } catch (IOException e) {
                System.err.println("Advice file does not exist, attempting to create");
                try {
                    fout = new PrintWriter(new FileOutputStream("advice.txt"));
                    firstRun = true;
                } catch (IOException f) {
                    System.err.println("Could not create file, try creating advice.txt manually");
                    System.exit(0);
                }
            }
        }

        try {
            fout = new PrintWriter(new FileOutputStream("advice.txt"));
        } catch (IOException e) {
            System.err.println("Could not find or access file");
            System.exit(0);
        }

        try {
            foutLog = new PrintWriter(new FileOutputStream("adviceLog.txt", true));
        } catch (IOException e) {
            System.err.println("Could not create file, try creating adviceLog.txt manually");
            System.exit(0);
        }

        if (firstRun) {
            System.out.println("You are the first advice-giver");
        }
        else {
            System.out.println("Here is the advice from the previous user:");
            while (fin.hasNextLine()) {
                System.out.println(fin.nextLine());
            }
        }

        System.out.println("Please enter some sagely advice for later users (press enter twice when finished):");
        do {
            advice = sc.nextLine();
            if (advice.equals("")) {
                break;
            }
            fout.println(advice);
            foutLog.println(advice);
        } while (!looper);
        foutLog.println(); //space for entries




        fin.close();
        fout.close();
        foutLog.close();
        sc.close();
    }
}
