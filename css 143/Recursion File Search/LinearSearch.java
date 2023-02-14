public class LinearSearch extends SearchAlgorithm {

    /**
     * Searches an array of Strings for a given String
     * @param words Array of Strings to search through
     * @param wordToFind Given String to search for
     * @return Index of given String in array
     * @throws ItemNotFoundException Thrown if given String does not exist in array
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        for (int i = 0; i < words.length; i++) {                                                                    // loop over array
            this.incrementCount();                                                                                  // count for each comparison
            if (words[i].equals(wordToFind)) {                                                                      // compare
                return i;                                                                                           // return if found
            }
        }

        throw new ItemNotFoundException("Could not find word");                                                     // throw exception if search completed without finding string
    }

    /**
     * Searches an array of Strings for a given String
     * @param words Array of Strings to search through
     * @param wordToFind Given String to search for
     * @return Index of given String in array
     * @throws ItemNotFoundException Thrown if given String does not exist in array
     */
    
     // threw a StackOverflowError, took too much to call method arr.length number of times on itself
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        this.incrementCount();                                                                                      // increment for each comparison
        if (!words[0].equals(wordToFind)) {
            String[] foo = new String[words.length - 1];                                                            // lopping off the first index to send the smaller array through recursion
            for (int i = 1; i < foo.length; i++) {                                                                  // loop over new array
                foo[i - 1] = words[i];                                                                              // copy each item to one index down in the new array
            }
            this.recSearch(foo, wordToFind);                                                                        // send new array through recursion to search for word
        } else {
            return (this.getCount() - 1);                                                                           // comparisons - 1 would be the index in the original array
        }

        return (this.getCount() - 1);                                                                               // send count back through
    }
}