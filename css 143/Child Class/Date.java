public class Date {
    /* invariants
     * days 1 - 31
     * months 1 - 12
     * years 2014 - 2024
     */

    private int month, day, year;
    private static final int MO_PER_YR = 12, DAY_PER_MO = 31;                                                       // conversion rates are constant

    /**
     * Constructor
     * @param month int form of given month 1 - 12
     * @param day given day 1 - 31
     * @param year given year 2014 - 2024
     */
    public Date(int month, int day, int year) {
        this.setMonth(month);
        this.setDay(day);
        this.setYear(year);
    }

    /**
     * Copy constructor
     * @param other Date object to be copied
     */
    public Date(Date other) {
        this(other.getMonth(), other.getDay(), other.getYear());
    }

    /**
     * Getter method
     * @return month field int
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Setter method
     * @param month as int
     */
    public void setMonth(int month) {
        if (month <= 0) {                                                                                           // if month is 0 or less (before january)
            System.err.println("Cannot have a month outside range 1 - 12, setting to 1");
            this.month = 1;
        } else if (month > 12) {                                                                                    // if month is over 1 year in length
            this.setYear(this.getYear() + (month / MO_PER_YR));                                                     // int math month over conversion is surplus years, add to years
            this.month = this.getMonth() % MO_PER_YR;                                                               // set months equal to remainder months
        } else {                                                                                                    // if month is between 1 and 12
            this.month = month;                                                                                     // set month to passed value
        }
    }

    /**
     * Getter method
     * @return day field
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Setter method
     * @param day 
     */
    public void setDay(int day) {
        if (day < 1) {                                                                                              // if day is less than 1 (before the month can happen)
            System.err.println("Cannot have a day outside range 1 - 31, setting to 1");
            this.day = 1;
        } else if (day > 31) {                                                                                      // if day is longer than month
            this.setMonth(this.getMonth() + (day / DAY_PER_MO));                                                    // add surplus months
            this.day = day % DAY_PER_MO;                                                                            // set remaining days 
        } else {                                                                                                    // if passed day is valid
            this.day = day;                                                                                         // set
        }
    }

    /**
     * Getter method
     * @return year field
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Setter method
     * @param year
     */
    public void setYear(int year) {
        if (year < 2014) {                                                                                          // if year before 2014, set at min (2014)
            System.err.println("Cannot have a year before 2014, setting to 2014");
            this.year = 2014;
        } else if (year > 2024) {                                                                                   // if year after 2024, roll over to start (2014)
            System.err.println("Year beyond acceptable range (2014 - 2024), rolling over to 2014");
            this.year = 2014;
        } else {                                                                                                    // if year in valid range
            this.year = year;
        }
    }

    /**
     * Checks for equality between Objects
     * @param o Generic Object to compare with
     * @return boolean for equality
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Date) || o == null) {
            return false;
        }
        Date date = (Date) o;
        return this.getMonth() == date.getMonth() && this.getDay() == date.getDay() && this.getYear() == date.getYear();
    }

    /**
     * @return String form of date as "m/d/y" format
     */
    @Override
    public String toString() {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }


}