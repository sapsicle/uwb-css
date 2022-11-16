public class DateFirstTry {

    public String month;
    public int day, year;
    public int hour, min;

    public void writeOutput() {
        System.out.println(month + " " + day + " " + year);
    }
    
    public void writeTime() {
        if (hour >= 24) {
            hour %= hour;
        }
                
        if (hour > 12) {
            System.out.println((hour - 12) + ":" + min + " PM");
        } else {
            System.out.println(hour + ":" + min + " AM");
        }
    }
}
