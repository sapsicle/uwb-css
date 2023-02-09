public class PermanentHire extends SalariedWorker {

    private double monthlyBonus;
    
    // constructors
    private PermanentHire() {

    }

    public PermanentHire(String name, int social) {
        super(name, social);
    }

    public PermanentHire(String name, int social, double pay) {
        super(name, social, pay);
    }

    // overridden methods
    @Override
    public double calculateWeeklyPay() {
        return super.calculateWeeklyPay() + this.monthlyBonus;
    }
}
