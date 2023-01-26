
/**
 * Write a description of class Date here.
 *
 * @author Meng
 * @version 9/30/2018
 */
public class Date {
    public static void main(String[] args) {
        Date d = new Date();
        d.setDate(10, 21, 2018);
        d.report();
    }

    //instance variables: "has a"
    private int month;
    private int day;
    private int year;

    // getters
    // no need to make copies to return as fields are primitives not objects
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
    
    //setter
    public void setDate(int m, int d, int y){//what should you check?
        if (checkDay(d) && checkMonth(m) && checkYear(y)) {                                         // if all date fields meet criteria
            this.day = d;                                                                           // set fields
            this.month = m;
            this.year = y;
        }
    }
    
    //prints out date
    public void report(){
        System.out.printf("%d/%d/%d\n", month, day, year);
    }

    // default no arg constructor
    // default to be 0 unix time
    public Date() {
        this.month = 1;
        this.day = 1;
        this.year = 1970;
    }

    // constructor to set date
    public Date(int month, int day, int year) {
        if (checkDay(day) && checkMonth(month) && checkYear(year)) {                                // if all date fields meet criteria
            this.day = day;                                                                         // set fields
            this.month = month;
            this.year = year;
        }
    }

    // copy constructor
    public Date(Date d) {                                                                           // no need to validate date fields as checks would've been run to set fields on d ensuring d meets criteria
        this.month = d.month;
        this.day = d.day;
        this.year = d.year;
    }

    // invariant checkers
    private boolean checkDay(int day) {
        if (day >= 1 && day <= 31)                                                                  // days must be between 1 and 31
            return true;
        else
            return false;
    }

    private boolean checkMonth(int month) {
        if (month >= 1 && month <= 12)                                                              // months must be between 1 and 12
            return true;
        else
            return false;
    }

    private boolean checkYear(int year) {
        if (year > 0)                                                                               // years must be positive
            return true;
        else
            return false;
    }

    // other
    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Date))
            return false;
        Date other = (Date) o;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }
}