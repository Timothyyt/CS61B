public class LinkedListDeque<T> {
    private Node dummy;
    private int size;

    private class Node {
        Node prev;
        T item;
        Node next;

        Node (Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // create an empty linked list deque
    public LinkedListDeque() {
        dummy = new Node(null, null, null);
        dummy.prev = dummy;
        dummy.next = dummy;
        size = 0;
    }

    // deep copy
    public LinkedListDeque(LinkedListDeque<T> other) {
        dummy = new Node(null, null, null);
        dummy.prev = dummy;
        dummy.next = dummy;

        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    // addFirst
    public void addFirst(T item) {
        Node node = new Node(dummy, item, dummy.next);
        dummy.next.prev = node;
        dummy.next = node;
        size += 1;
    }

    // addLast
    public void addLast(T item) {
        Node node = new Node(dummy.prev, item, dummy);
        dummy.prev.next = node;
        dummy.prev = node;
        size += 1;
    }

    // removeFirst
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        T first = dummy.next.item;
        dummy.next = dummy.next.next;
        dummy.next.prev = dummy;
        size--;
    }

    // removeLast
    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        T last = dummy.prev.item;
        dummy.prev = dummy.prev.prev;
        dummy.prev.next = dummy;
        size--;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // get
    public T get(int index) {
        if (index > size) {
            return null;
        }

        Node curt = dummy.next;

        while (index > 0) {
            curt = curt.next;
            index--;
        }

        return curt.item;
    }

    // getRecursive
    public T getRecursive(int index) {
        return getRecursiveHelper(dummy.next, index);
    }

    private T getRecursiveHelper(Node curt, int index) {
        if (index == 0) {
            return curt.item;
        } else {
            return getRecursiveHelper(curt.next, --index);
        }
    }

    // size
    public int size() {
        return size;
    }

    // printDeque
    public void printDeque() {
        Node curt = dummy.next;
        while (curt != dummy) {
            System.out.print(curt.item + " ");
            curt = curt.next;
        }
        System.out.println();
    }
}
