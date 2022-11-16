import java.util.*;
import java.io.*;
public class HW_Arrays {

    public static final double AIR_DENSITY = 1.14; // in kg/m^3
    public static final double GRAV_ACCEL = 9.81; // in m/s^2

    public static void main(String[] args) {
        boolean looping;
        Scanner kin = new Scanner(System.in);
        PrintWriter fout = null;
        do {
            looping = false;

            double[][] velocities = null;
            /*
            * works better in my head to tie t and v(t) together like this using 2D array
            * row 0 is t
            * row 1 is v(t)
            * 
            * velocities[0][0] is the first time t
            * velocities[0][1] is the velocity v(t) at time t
            * 
            * delta t (timestep) is defined here as (velocities[1][0] - velocities[0][0])
            */


            double mass = 0, area = 0, dragCoeff = 0, timestep = 0;
            int endTime = 0;
            String filename = "arrayhwOutput.csv";
            System.out.print("Enter the mass of the skydiver (kg): ");
            try {
                mass = kin.nextDouble();
                if (mass <= 0) {
                    throw new InputMismatchException("Less than 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid real number");
                System.exit(0);
            }

            System.out.print("Enter the cross-sectional area of the skydiver (m^2): ");
            try {
                area = kin.nextDouble();
                if (area <= 0) {
                    throw new InputMismatchException("Less than 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid real number");
                System.exit(0);
            }

            System.out.print("Enter the drag coefficient of the skydiver: ");
            try {
                dragCoeff = kin.nextDouble();
                if (dragCoeff <= 0) {
                    throw new InputMismatchException("Less than 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid real number");
                System.exit(0);
            }

            System.out.print("Enter the ending time (sec): ");
            try {
                endTime = kin.nextInt();
                if (endTime <= 0) {
                    throw new InputMismatchException("Less than 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid whole number");
                System.exit(0);
            }

            System.out.print("Enter the time step (sec): ");
            try {
                timestep = kin.nextDouble();
                if (timestep <= 0) {
                    throw new InputMismatchException("Less than 0");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid real number");
                System.exit(0);
            }

            System.out.print("Enter the output file name (include csv extension): ");
            try {
                filename = kin.next();

                // String ext = filename.substring((filename.length() - 3));
                // if (!ext.equals(".csv")) {
                //     throw new InputMismatchException("Invalid file type");
                // }

            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid file name");
                System.exit(0);
            }

            try {
                fout = new PrintWriter(new FileOutputStream("files/" + filename, true));
            } catch (IOException e) {
                System.err.println("Problem creating file");
                System.exit(0);
            }

            System.out.println("Writing out file, here are the first few lines:");

            int steps = (int)(endTime / timestep);
            velocities = new double[steps + 1][2]; //initialize array with length equal to # of steps (plus 1 for time 0) and 2 rows
            velocities[0][0] = 0;
            velocities[0][1] = 0; //velocity is 0 at time 0

            for (int i = 1; i < velocities.length; i++) {
                velocities[i][0] = timestep * i;
                
                velocities[i][1] = velocities[i-1][1] + (GRAV_ACCEL - (dragCoeff * AIR_DENSITY * area) / (2 * mass) * Math.pow(velocities[i-1][1], 2)) * timestep;
                //stores velocity data in [i][1], the v(t) half of the array

                fout.printf("%.3f, %.4f\n", velocities[i][0], velocities[i][1]);

                if (i <= 4) {
                    System.out.printf("%.3f, %.4f\n", velocities[i][0], velocities[i][1]);
                }
            }

            fout.println(); //separator in case multiple dives

            System.out.println("Enter another dive? (y/N): ");
            char again = kin.next().toLowerCase().charAt(0);
            switch (again) {
                case 'y': looping = true;
                    break;
                case 'n': looping = false;
                    break;
                default: looping = false;
                    break;
            }

        } while (looping);
        fout.close();
        kin.close();
    }
}