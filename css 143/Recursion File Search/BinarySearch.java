public class BinarySearch extends SearchAlgorithm {

    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int low = 0;                                                                                                // initial lower bound 0
        int high = words.length - 1;                                                                                // initial upper bound end of array
        
        while (low <= high) {                                                                                       // loop while the lower bound is still below upper
            int mid = (low + high) / 2;                                                                             // midpoint is halfway between upper and lower
            int compare = words[mid].compareTo(wordToFind);                                                         // check which half target word is in
            this.incrementCount();                                                                                  // increment count for comparison
            if (compare < 0) {                                                                                      // if in the upper half
                low = mid + 1;                                                                                      // new lower bound just above old midpoint
            } else if (compare > 0) {                                                                               // if in lower half
                high = mid - 1;                                                                                     // new upper bound just below old midpoint
            } else {                                                                                                // only edge case is if target word equals midpoint word
                return mid;                                                                                         // return midpoint index
            }
        }
        
        throw new ItemNotFoundException("Could not find word");                                                     // if loop finishes without finding word, throw
    }

    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {                          // facade method
        return this.recSearchHelper(words, wordToFind, 0, words.length - 1);                                        // call actual search method
    }
 
    private int recSearchHelper(String[] arr, String target, int low, int high) throws ItemNotFoundException {
        if (low > high) {
            throw new ItemNotFoundException("Could not find word");                                                 // lower bound greater than upper bound means target not found
        }

        int mid = (low + high) / 2;                                                                                 // calc midpoint
        int compare = arr[mid].compareTo(target);                                                                   // is target word before or after the midpoint
        this.incrementCount();                                                                                      // count comparison

        if (compare == 0) {                                                                                         // if target equals midpoint word
            return mid;                                                                                             // return midpoint index
        } else if (compare < 0) {                                                                                   // if in upper half
            return recSearchHelper(arr, target, mid + 1, high);                                                     // search upper half
        } else {                                                                                                    // if in lower half
            return recSearchHelper(arr, target, low, mid - 1);                                                      // search lower half
        }
    }
}