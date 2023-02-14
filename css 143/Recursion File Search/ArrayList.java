public class ArrayList {
    private Object[] objArr, tempArr;
    private int usedIndices;
    
    /**
     * Constructor sets default size 10
     */
    public ArrayList() {
        this.objArr = new Object[10];
        this.usedIndices = 0;
    }

    /**
     * Constructor with custom default size
     * @param size Initial size of ArrayList
     */
    public ArrayList(int size) {
        this.objArr = new Object[size];
        this.usedIndices = 0;
    }

    /**
     * Increases array size by 10 when needed
     */
    private void increaseSize() {                                                                   
        this.tempArr = new Object[this.size()];                                                     // reform temporary array to hold objects at objArr size
        
        for (int i = 0; i < this.size(); i++) {                                                     // loop through and transfer objects
            this.tempArr[i] = this.objArr[i];
        }

        this.objArr = new Object[this.size() + 10];                                                 // remake array 10 spots larger than before
        for (int i = 0; i < this.size(); i++) {                                                     // loop through and transfer objects back
            this.objArr[i] = this.tempArr[i];
        }
    }

    /**
     * @return Number of elements in ArrayList
     */
    public int size() {
        return this.usedIndices;                                                                    // current used size of ArrayList
    }

    // not specified by instructions but makes it easier to add to the end
    /**
     * Adds an object to the end of the ArrayList
     * @param o Object to be added
     */
    public void add(Object o) {
        this.objArr[this.usedIndices] = o;
        this.usedIndices++;
    }

    /**
     * Inserts element into given index
     * @param obj Object to be inserted
     * @param index Index at which to insert
     * @throws IndexOutOfBoundsException
     */
    public void insert(Object obj, int index) throws IndexOutOfBoundsException {
        if (index > this.usedIndices)                                                               // index must not be equal or greater than usedIndices e.g. an index of 2 corresponds the 3rd used index
            throw new IndexOutOfBoundsException();                                                  // throw exception if outside allowed size

        if ((this.size() + 1) > this.objArr.length)                                                 // if adding an entry would exceed the array size i.e. array is at capacity already
            increaseSize();                                                                         // increase the size of the array

        for (int i = this.size(); i > index; i--) {                                                 // starting at the end, loop backwards until specified index is emptied upwards
            this.objArr[i] = this.objArr[i-1];                                                      // move each entry up 1 index
        }

        this.objArr[index] = obj;                                                                   // set incoming object into specified index
        this.usedIndices++;                                                                         // increase counter for number of objects in array
    }

    /**
     * Removes element at given index
     * @param index Index at which to remove object
     * @return Removed object
     */
    public Object remove(int index) {
        Object foo = this.objArr[index];                                                            // store object before it gets removed
        for (int i = index; i < this.size(); i++) {
            this.objArr[i] = this.objArr[i+1];                                                      // move each entry down one, eliminating the entry being removed
        }
        this.usedIndices--;                                                                         // decrement count for num of objects
        return foo;                                                                                 // return removed object
    }

    /**
     * Returns single string list of Object class names
     */
    @Override
    public String toString() {
        String foo = "";
        for (int i = 0; i < this.size(); i++) {
            foo += this.objArr[i] + " ";                                                 // add each object class name into a single string list
        }
        return foo;
    }

    /**
     * @return Whether ArrayList holds no elements
     */
    public boolean isEmpty() {
        if (this.size() == 0) return true;                                                          // return true if no indices are being used
        else return false;                                                                          // return false if objects exist in array
    }

    /**
     * @param o Object to search for
     * @return Index at which element resides, returns -1 if not found
     */
    public int indexOf(Object o) {
        for (int i = 0; i < this.size(); i++) {
            if (this.objArr[i].equals(o)) return i;                                                 // if object in array equals o return i as index
        }
        return -1;                                                                                  // -1 if not found
    }

    /**
     * Checks for equality between two ArrayLists
     * @param arrli ArrayList to compare against
     * @return Whether ArrayLists are equal
     */
    public boolean equals(ArrayList arrli) {
        if (this.size() != arrli.size()) return false;                                              // if different sizes return false

        for (int i = 0; i < this.size(); i++) {
            if (!this.objArr[i].equals(arrli)/*built-in object method*/) return false;              // if any given object is not the same in both arrays return false
        }

        return true;                                                                                // return true if all is equal
    }

    /**
     * @param index Index at which to get element
     * @return Object at given index
     */
    public Object get(int index) {
        return this.objArr[index];
    }
}