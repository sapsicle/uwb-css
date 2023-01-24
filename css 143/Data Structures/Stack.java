public class Stack {
    private int usedIndices;
    private Object[] objArr, tempArr;

    /**
     * Constructor sets default size 10
     */
    public Stack() {
        this.objArr = new Object[10];
        this.usedIndices = 0;
    }

    /**
     * Constructor with custom default size
     * @param size Initial size of Stack
     */
    public Stack(int size) {
        this.objArr = new Object[size];
        this.usedIndices = 0;
    }
    
    /** Reused from ArrayList
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
     * @return Number of elements in Stack
     */
    public int size() {
        return this.usedIndices;                                                                    // current used size of Stack
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
     * @return Whether Stack holds no elements
     */
    public boolean isEmpty() {
        if (this.size() == 0) return true;                                                          // return true if no indices are being used
        else return false;                                                                          // return false if objects exist in array
    }

    /**
     * Checks for equality between two Stacks
     * @param stack Stack to compare against
     * @return Whether Stacks are equal
     */
    public boolean equals(Stack stack) {
        if (this.size() != stack.size()) return false;                                              // if different sizes return false

        for (int i = 0; i < this.size(); i++) {
            if (!this.objArr[i].equals(stack)/*built-in object method*/) return false;              // if any given object is not the same in both arrays return false
        }

        return true;                                                                                // return true if all is equal
    }

    /**
     * Add object to top of stack
     * @param o Object to be added
     */
    public void push(Object o) {
        if ((this.size() + 1) > this.objArr.length)                                                 // if adding an entry would exceed the array size i.e. array is at capacity already
            increaseSize();                                                                         // increase the size of the array
        
        this.objArr[this.usedIndices] = o;                                                          // add o to top of stack which is current # of indices, adding a 3rd item to a stack of 2 would add it to index 2
        this.usedIndices++;                                                                         // increase counter for stack entries
    }

    /**
     * Pulls top object off stack
     * @return Top object
     */
    public Object pop() {
        Object foo = this.objArr[this.usedIndices-1];                                               // stores top entry which is indices - 1 (index 2 is the 3rd entry therefore a stack of 3 would pop this.objArr[2])
        this.usedIndices--;                                                                         // decrease counter, no need to remove entry as it'll be overwritten later if entry added to index
        return foo;
    }
}