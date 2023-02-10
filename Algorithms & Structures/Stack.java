public class Stack {
    // inner class Node
    private class Node {
        private int data;
        private Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int newData, Node link) {
            this.data = newData;
            this.next = link;
        }
    }

    // outer class Stack starts here
    private Node head;

    public Stack() {
        this.head = null;
    }

    public Stack(int newData) {
        this.head = new Node(newData, null);
    }

    public void push(int pushMe) {
        this.head = new Node(pushMe, this.head);
    }

    public int pop() {
        int returnVal = this.head.data;
        this.head = this.head.next;
        return returnVal;
    }
}