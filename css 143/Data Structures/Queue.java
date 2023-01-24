
public class Queue {
    private int usedIndices;
    private Object[] objArr, tempArr;

    /**
     * Constructor sets default size 10
     */
    public Queue() {
        this.objArr = new Object[10];
        this.usedIndices = 0;
    }

    /**
     * Constructor with custom default size
     * @param size Initial size of Queue
     */
    public Queue(int size) {
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
     * @return Number of elements in Queue
     */
    public int size() {
        return this.usedIndices;                                                                    // current used size of Queue
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
     * @return Whether Queue holds no elements
     */
    public boolean isEmpty() {
        if (this.size() == 0) return true;                                                          // return true if no indices are being used
        else return false;                                                                          // return false if objects exist in array
    }

    /**
     * Checks for equality between two Queues
     * @param stack Queue to compare against
     * @return Whether Queues are equal
     */
    public boolean equals(Queue queue) {
        if (this.size() != queue.size()) return false;                                              // if different sizes return false

        for (int i = 0; i < this.size(); i++) {
            if (!this.objArr[i].equals(queue)/*built-in object method*/) return false;              // if any given object is not the same in both arrays return false
        }

        return true;                                                                                // return true if all is equal
    }

    /**
     * Adds objects to end of queue
     * @param o Object being enqueued
     */
    public void enqueue(Object o) {
        if ((this.size() + 1) > this.objArr.length)                                                 // if adding an entry would exceed the array size i.e. array is at capacity already
            increaseSize();                                                                         // increase the size of the array
        
        this.objArr[this.usedIndices] = o;                                                          // add o to end of queue which is current # of indices, adding a 3rd item to a queue of 2 would add it to index 2
        this.usedIndices++;                                                                         // increase counter for queue entries
    }

    /**
     * Pulls first position in the queue
     * @return Index 0 in queue
     */
    public Object dequeue() {
        Object foo = this.objArr[0];                                                                // stores the first entry in the queue
        for (int i = 0; i < this.size(); i++) this.objArr[i] = this.objArr[i+1];                    // move each entry up one index in the queue, overwriting previous first slot
        this.usedIndices--;                                                                         // decrement counter
        return foo;
    }
}
