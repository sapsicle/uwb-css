public class YoungHuman {
    /* invariants
     * checkup date >= birth date
     * current date >= birth date
     */

    private Weight currentWeight;
    private Date birthDate, lastCheckupDate;
    private String firstName, lastName;

    /**
     * Constructor for all values
     * @param weight
     * @param birthDate
     * @param firstName
     * @param lastName
     */
    public YoungHuman(Weight weight, Date birthDate, String firstName, String lastName) {
        this.setCurrentWeight(weight);                                                                              // use setter methods to create new objects
        this.setBirthDate(birthDate);                                                                               // use setter methods to create new objects
        this.setFirstName(firstName);                                                                               // use setter methods to create new objects
        this.setLastName(lastName);                                                                                 // use setter methods to create new objects
        this.unsetCheckupDate();                                                                                    // use unset method to set to null
    }

    /**
     * Copy constructor
     * @param toCopy
     */
    public YoungHuman(YoungHuman toCopy) {
        this(toCopy.getCurrentWeight(), toCopy.getBirthDate(), toCopy.getFirstName(), toCopy.getLastName());        // reuse existing constructor
    }

    /**
     * Getter method
     * @return current Weight object
     */
    public Weight getCurrentWeight() {
        return new Weight(this.currentWeight);                                                                      // new object to prevent privacy leaks
    }

    /**
     * Setter method
     * @param currentWeight Weight object for current weight
     */
    public void setCurrentWeight(Weight currentWeight) {
        this.currentWeight = new Weight(currentWeight);                                                             // new object to prevent privacy leaks
    }

    /**
     * Getter method
     * @return birth Date object
     */
    public Date getBirthDate() {
        return new Date(this.birthDate);                                                                            // new object to prevent privacy leaks
    }

    /**
     * Setter method
     * @param setBirthDate Date object for birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = new Date(birthDate);                                                                       // new object to prevent privacy leaks
    }

    /**
     * Getter method
     * @return Last checkup Date object
     */
    public Date getLastCheckupDate() {
        return new Date(this.lastCheckupDate);                                                                      // new object to prevent privacy leaks
    }

    /**
     * Setter method
     * @param lastCheckupDate Date object for last checkup date
     */
    public void setLastCheckupDate(Date lastCheckupDate) {
        this.lastCheckupDate = new Date(lastCheckupDate);                                                           // new object to prevent privacy leaks
    }

    /**
     * Getter method
     * @return first name as String
     */
    public String getFirstName() {
        return this.firstName;                                                                                      // no need for new object, strings get copied internally
    }

    /**
     * Setter method
     * @param firstName String for first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;                                                                                 // no need for new object, strings get copied internally
    }

    /**
     * Getter method
     * @return last name as String
     */
    public String getLastName() {
        return this.lastName;                                                                                       // no need for new object, strings get copied internally
    }

    /**
     * Setter method
     * @param lastName String for last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;                                                                                   // no need for new object, strings get copied internally
    }

    /**
     * Setter method
     * @param firstName String for first name
     * @param lastName String for last name
     */
    public void setName(String firstName, String lastName) {
        this.setFirstName(firstName);                                                                               // use methods for ease
        this.setLastName(lastName);                                                                                 // use methods for ease
    }

    /**
     * Getter method
     * @return full name as String "first last"
     */
    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    /**
     * Boolean method to check if lastCheckupDate is null Date object
     * @return false if null, true if has Date object
     */
    public boolean hasHadCheckup() {
        if (this.lastCheckupDate == null) return false;                                                             // checks if object is null, null means no checkup stored
        else return true;
    }

    /**
     * Method to set Date object lastCheckupDate to null
     */
    public void unsetCheckupDate() {
        this.lastCheckupDate = null;                                                                                // remove date by setting to null
    }

    /**
     * Create String object with relevant information
     * @return String of patient information
     */
    @Override
    public String toString() {
        String foo =                                                                                                // store given info in string
                           this.getName() +
                    ", " + this.getCurrentWeight().toString() + 
        ", birth date: " + this.getBirthDate().toString();

        if (this.lastCheckupDate == null) {foo += ", has not had a checkup";}                                       // check if checkup exists and append appropriate string
        else {foo += ", last checkup: " + this.getLastCheckupDate().toString();}

        return foo;                                                                                                 // return string
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
        if (!(o instanceof YoungHuman) || o == null) {
            return false;
        }
        YoungHuman youngHuman = (YoungHuman) o;
        return this.getCurrentWeight().equals(youngHuman.getCurrentWeight()) &&                                     // return boolean comparison of values & objects
               this.getBirthDate().equals(youngHuman.getBirthDate()) && 
               this.getFirstName().equals(youngHuman.getFirstName()) && 
               this.getLastName().equals(youngHuman.getLastName()) && 
               this.getLastCheckupDate().equals(youngHuman.getLastCheckupDate());
    }
}