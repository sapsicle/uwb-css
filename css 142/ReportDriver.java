import java.util.*;
public class ReportDriver {
    public static void main(String[] args) {
        RaceReport reporter = new RaceReport();
        Scanner sc = new Scanner(System.in);
        String raceLoop;
        
        boolean loopControl = true;
        do {
            reporter.writeReport();

            System.out.print("Enter another race? (y/N): ");
            raceLoop = sc.next();
            raceLoop.toLowerCase();
            switch (raceLoop) {
                case "y": loopControl = true;
                    break;
                default: loopControl = false;
                    break;
            }
        } while (loopControl);
        
        sc.close();
    }
}