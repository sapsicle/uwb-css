public class CharList {
    // no string > 100

    private char[] list;
    private int numChars;

    public CharList() {
        this.list = new char[100];                                                                  // empty array length 100
    }

    public CharList(String startStr) {
        this.list = new char[100];                                                                  // initialize list to 100
        this.numChars = startStr.length();                                                          // num of chars is equal to the num in the starting string
        for (int i = 0; i < this.numChars; i++)                                                     // loop through num of chars
            list[i] = startStr.charAt(i);                                                           // place each char in list sequentially
    }

    public CharList(CharList other) throws NullPointerException {
        if (other == null || other.isEmpty())
            throw new NullPointerException("CharList is empty or null");                            // throw exception if charlist has no values, user must handle

        this.numChars = other.numChars;                                                             // copy counter value
        
        if (other.list.length > 100)
            this.list = new char[other.list.length];                                                // if list being copied is longer than default length 100 set to length
        else
            this.list = new char[100];                                                              // set to 100 if under default

        for (int i = 0; i < this.numChars; i++)
            this.list[i] = other.list[i];                                                           // copy chars into new list
    }

    // unrequired method, syntactically makes null checking easier
    public boolean isEmpty() {
        if (this.numChars <= 0)                                                                     // list is empty if counter is 0 (or somehow less)
            return true;
        else                                                                                        // not empty if counter is > 0
            return false;
    }

    public void add(char next) {
        this.list[numChars] = next;                                                                 // index of num chars would be empty, a list with numChars = 3 would have its final char at list[2] therefore add(char) would place the next one at list[3] and increase counter to 4
        this.numChars++;                                                                            // incremement counter
    }

    public char get(int index) {
        return this.list[index];
    }

    @Override
    public String toString() {
        String foo = "";                                                                            // initialize empty string
        for (int i = 0; i < this.numChars; i++)
            foo += this.list[i];                                                                    // concatenate each char
        return foo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)                                                                              // if object checks itself
            return true;
        if (!(o instanceof CharList) || o == null)                                                  // if object is not an instance of CharList or if null
            return false;
        CharList charList = (CharList) o;
        if (this.numChars != charList.numChars)                                                     // if different number of chars
            return false;
        for (int i = 0; i < this.numChars; i++) {
            if (this.list[i] != charList.list[i])                                                   // compare each char
                return false;                                                                       // return false as soon as a pair does not equate
        }
        return true;                                                                                // if loop finishes (all pairs were equal) return true
    }

    // method required for driver, was not specified in lab instructions
    public int size() {
        return this.numChars;
    }
}
