public class Date {
    private short day, month, year;

    public Date(short day, short month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    public void setDate(short day, short month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void nextDay() {

    }
    
    public void nextMonth() {

    }
    
    public void nextYear() {

    }
    
    public short getDay() {
        return this.day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public short getMonth() {
        return this.month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public short getYear() {
        return this.year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    
}
