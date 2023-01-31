public class Weight {
    /* invariants
     * ounces 0 - 15
     * pounds ounces > 0
     */

    private int pounds, ounces;
    private static final int OZ_PER_LB = 16;                                                                        // oz to lb conversion is constant

    /**
     * Constructor
     * @param lbs
     */
    public Weight(int lbs) {
        this.setPounds(lbs);
        this.setOunces(0);                                                                                          // sets ounces to 0
    }

    /**
     * Constructor
     * @param lbs
     * @param oz
     */
    public Weight(int lbs, int oz) {
        this.setPounds(lbs);
        this.setOunces(oz);
    }

    /**
     * Constructor
     * @param other Weight object to be copied
     */
    public Weight(Weight other) {
        this(other.pounds, other.ounces);                                                                           // send other's details into existing constructor
    }

    /**
     * Getter method
     * @return pounds of patient
     */
    public int getPounds() {
        return this.pounds;
    }

    /**
     * Setter method
     * @param pounds pounds of patient
     */
    public void setPounds(int pounds) {
        if (pounds < 0) {                                                                                           // if negative pounds
            System.err.println("Cannot have negative pounds, setting to 0");
            this.pounds = 0;
        } else {                                                                                                    // if non-negative
            this.pounds = pounds;
        }
    }

    /**
     * Getter method
     * @return ounces of patient
     */
    public int getOunces() {
        return this.ounces;
    }

    /**
     * Setter method
     * @param ounces ounces of patient
     */
    public void setOunces(int ounces) {
        if (ounces >= 0 && ounces < OZ_PER_LB) {                                                                    // if not negative and not surplus (pound or more)
            this.ounces = ounces;
        } else if (ounces >= OZ_PER_LB) {                                                                           // if ounces is equal to or greater than a pound
            this.pounds += ounces / OZ_PER_LB;                                                                      // int math / by 16 is surplus pounds in oz, add on to pounds
            this.ounces = ounces % OZ_PER_LB;                                                                       // mod by 16 to get remaining ounces
        } else {                                                                                                    // if negative ounces 
            System.err.println("Cannot have negative ounces, setting to 0");
            this.ounces = 0;
        }
    }

    /**
     * Setter method
     * @param pounds pounds of patient
     * @param ounces ounces of patient
     */
    public void setWeight(int pounds, int ounces) {
        this.setPounds(pounds);
        this.setOunces(ounces);
    }

    /**
     * Getter method
     * @return full weight of patient in decimal form
     */
    public double getWeight() {
        return this.getPounds() + ((double)this.getOunces() / OZ_PER_LB);                                           // pounds plus decimalized ounces
    }

    /**
     * Add pounds to patient weight
     * @param lbs number of pounds to add, positive or negative
     */
    public void add(int lbs) {
        if ((this.getPounds() + lbs) < 0) {                                                                         // if negative gain would create negative weight
            System.err.println("Patient cannot have negative weight, setting to 0");
            this.setPounds(0);
            return;                                                                                                 // exit method
        }

        this.setPounds(this.getPounds() + lbs);                                                                     // set new weight if valid gain/loss
    }

    /**
     * Add pounds and ounces to patient weight
     * @param lbs number of pounds to add, positive or negative
     * @param oz number of ounces to add, positive or negative
     */
    public void add(int lbs, int oz) {
        this.add(lbs);                                                                                              // reuse method for pounds

        if ((this.getOunces() + oz) < 0) {                                                                          // check if gain/loss would create negative pounds
            int foo = this.getOunces() + oz;                                                                        // store ounce deficit
            if (Math.abs(foo) >= 16) {                                                                              // if greater than a pound
                this.add(foo / OZ_PER_LB);                                                                          // add (subtract as it's negative) number of pounds
            } else {                                                                                                // if under a pound
                this.setOunces(this.getOunces() + oz);                                                              // add negative ounces
            }
        } else {                                                                                                    // if ounce gain/loss does not produce negative weight
            this.setOunces(this.getOunces() + oz);                                                                  // add ounces
        }
    }

    /**
     * Add the weight of another patient to current patient
     * @param other Patient whose weight to add
     */
    public void add(Weight other) {
        this.add(other.getPounds(), other.getOunces());                                                             // add pounds from other, use existing method for ease of invariant checking
    }

    /**
     * Checks for equality between Objects
     * @param o Generic Object to compare with
     * @return boolean for equality
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)                                                                                              // if invoking object checking itself
            return true;
        if (!(o instanceof Weight) || o == null) {                                                                  // if object is not Weight or is null
            return false;
        }
        Weight weight = (Weight) o;                                                                                 // cast to weight
        return this.getPounds() == weight.getPounds() && this.getOunces() == weight.getOunces();                    // return boolean comparison of values
    }

    /**
     * @return String form of patient weight in "X lbs. Y oz." format
     */
    @Override
    public String toString() {
        return this.getPounds() + " lbs. " + this.getOunces() + " oz.";
    }
}