import java.util.*;
import java.io.*;
public class HW_Loops_Files {
    public static void main(String[] args) {
        Scanner fin = null;
        try {
            fin = new Scanner(new FileInputStream("courseData.txt"));
        } catch (IOException e) {
            System.err.println("File not found");
            System.exit(0);
        }

        double programWeight = fin.nextDouble();
        double midtermWeight = fin.nextDouble();
        double finalWeight = fin.nextDouble();
        int studentID, programScore, midtermScore, finalScore;
        boolean looper1 = false;
        int testValues;

        do {
            headerPrinter(fin.nextInt());
            double classSum = 0, numStudents = 0;
            boolean looper2 = false;

            do {
                testValues = fin.nextInt();
                if (testValues == 0) {
                    //if next number is 0, break and start next section
                    break;
                } else {
                    studentID = testValues;
                }
                programScore = fin.nextInt();
                midtermScore = fin.nextInt();
                finalScore = fin.nextInt();

                System.out.printf("%d %4d %11d %11d", studentID, programScore, midtermScore, finalScore);

                double weightedProgram = programScore * programWeight;
                double weightedMidterm = midtermScore * midtermWeight;
                double weightedFinal = finalScore * finalWeight;
                double weightedSum = weightedProgram + weightedMidterm + weightedFinal;

                classSum += weightedSum;
                numStudents++;

                System.out.printf("%12.1f", weightedSum);

                String progGrade;
                if (programScore >= 70) {
                    progGrade = "Pass";
                } else {
                    progGrade = "Fail";
                }
                System.out.printf("%17s\n", progGrade);
                
            } while (!looper2);

            double classAverage = classSum / numStudents;
            System.out.printf("Class Average: %.2f\n\n", classAverage);

            if (testValues == 0 && fin.nextLine().equals("")) {
                looper1 = true;
            }

        } while (!looper1);

    }

    public static void headerPrinter(int classNum) {
        System.out.println("Grade Data For Class " + classNum);
        System.out.printf("%-6s %-11s %-11s %-9s %-16s %-14s\n","ID", "Program", "Midterm", "Final", "Weighted Sum", "Programs Grade");
        System.out.printf("%-6s %-11s %-11s %-9s %-16s %-14s\n","--", "-------", "-------", "-----", "------------", "--------------");
    }
}