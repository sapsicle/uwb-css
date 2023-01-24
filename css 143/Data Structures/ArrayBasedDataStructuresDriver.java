/*
 *  Incomplete Driver (and testing harness) for ArrayList, Stack, and Queue
 * 
 * 
 */
public class ArrayBasedDataStructuresDriver {
    public static void main(String[] args) {
        stackTests();
        queueTests();
        arrayListTests();
    }

    /**
     * arrayListTests
     * ----------
     * This method runs all the tests on the ArrayList class
     */
    private static void arrayListTests() {
        System.out.println(); // line space
        ArrayList foo = new ArrayList(5);
        
        // testing adding items
        foo.add("string");
        foo.add('c');
        foo.insert(5, 0);


        System.out.println("should print Integer, String, Char");
        System.out.println(foo.toString());

        foo.remove(1);

        System.out.println("should print Integer, Char");
        System.out.println(foo.toString());

        System.out.print("testing equals ");
        ArrayList bar = new ArrayList();
        System.out.println(foo.equals(bar));

        System.out.println("foo is empty: " + foo.isEmpty());
        System.out.println("bar is empty: " + bar.isEmpty());

    }

    /**
     * queueTests
     * ----------
     * This method runs all the tests on the Queue class
     */
    private static void queueTests() {
        System.out.println(); // line space
        Queue foo = new Queue(5);
        foo.enqueue("string");
        foo.enqueue('c');
        foo.enqueue(5);

        System.out.println("string: " + foo.toString());

        System.out.println("dequeue: " + foo.dequeue());
        System.out.println(foo.toString());

        // all other methods are reused from arraylist
    }

    /**
     * stackTests
     * ----------
     * This method runs all the tests on the Stack class
     */
    private static void stackTests() {
        System.out.println(); // line space
        Stack foo = new Stack(5);
        foo.push("string");
        foo.push('c');
        foo.push(5);

        System.out.println("String: " + foo.toString());
        System.out.println("Pop: " + foo.pop());
        System.out.println("String: " + foo.toString());
    }
}