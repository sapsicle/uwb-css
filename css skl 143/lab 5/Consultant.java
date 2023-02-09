public class Consultant extends HourlyWorker {
    
    private double hoursWorked;

    // constructors
    private Consultant() {
        
    }

    public Consultant(String name, int social) {
        super(name, social);
        this.hoursWorked = 20;
        this.setHourlyPay(3);

    }

    public Consultant(String name, int social, double pay) {
        super(name, social);
        this.hoursWorked = 20;
        this.setHourlyPay(pay);
    }

    // overridden methods
    @Override
    public double calculateWeeklyPay() {
        return this.getHourlyPay() * this.hoursWorked;
    }
}
