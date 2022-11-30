import java.util.*;
public class Race {
    public double[] readInTimes() {
        Scanner sc = new Scanner(System.in);
        double[] times = new double[3];

        times[0] = sc.nextDouble();
        times[1] = sc.nextDouble();
        times[2] = sc.nextDouble();

        sc.close();
        return times;
    }

    public double[] sortTimesAscending(double[] times) {
        double[] sortedTimes = {0, 0, 0};

        sortedTimes[0] = Math.min(times[0], Math.min(times[1], times[2]));
        sortedTimes[2] = Math.max(times[0], Math.max(times[1], times[2]));
        
        sortedTimes[1] = (times[0] + times[1] + times[2]) - (sortedTimes[0] + sortedTimes[2]);
       
        return sortedTimes;
    }

    public double range(double[] times) {
        double range = 0;
        double max = 0, min = 100_000_000;

        for (double var : times) {
            if (var > max) {
                max = var;
            }

            if (var < min) {
                min = var;
            }
        }

        range = max - min;

        return range;
    }

    public double average(double[] times) {
        double average = 0;

        for (double var : times) {
            average += var;
        }
        average /= times.length;

        return average;
    }
}