public class Date {
    private int day, month, year;

    public static void main(String[] args) {
        Date date1 = new Date();
        date1.report();
        date1.setDate(12, 9, 2001);
        date1.report();

        Date date2 = new Date(18, 1, 2023);
        date2.report();
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void report() {
        System.out.println(this.month + "/" + this.day + "/" + this.year);
    }
    
    // public void nextDay() {
    //     this.day++;
    //     checkIncrement();
    // }
    
    // private void nextMonth() {
    //     this.month++;
    // }
    
    // private void nextYear() {
    //     this.year++;
    // }

    // private void checkIncrement() {
    //     switch ()
    // }
    
    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
/*
 * tried to use enums to store days and things so i could have methods to increment to the next day and check if months or years rolled over
 * scrapped idea as i couldn't realistically implement in a simple program like this
 * would've overshadowed the actual assignment
 */
// enum Months {
//     January (31), 
//     February (28), 
//     March (31), 
//     April (30), 
//     May (31), 
//     June (30), 
//     July (31),
//     August (31),
//     September (30),
//     October (31),
//     November (30),
//     December (31);

//     private final int days;

//     private Months(int days) {
//         this.days = days;
//     }
// }