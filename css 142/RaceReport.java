public class RaceReport {
    private double[] times; //private instance var
    public void writeReport() {
        Race race = new Race();

        System.out.print("Enter the race times (in seconds): ");
        times = race.readInTimes();

        System.out.println(); //separator
            
        double[] sortedTimes = race.sortTimesAscending(times);
        System.out.printf("First place (time in seconds): %.1f\n", sortedTimes[0]);
        System.out.printf("Second place (time in seconds): %.1f\n", sortedTimes[1]);
        System.out.printf("Third place (time in seconds): %.1f\n", sortedTimes[2]);

        System.out.println(); //separator

        System.out.printf("The range of the race times (in seconds): %.1f\n", race.range(times));
        System.out.printf("The average time of all racers (in seconds): %.1f\n", race.average(times));

        System.out.println(); //separator
    }
}