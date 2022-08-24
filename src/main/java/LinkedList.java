public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }

    public E getFirst() {
        return first.value;
    }

    public E getLast() {
        return last.value;
    }

    public int size() {
        return size;
    }

    private static class Node<V> {
        V value;
        Node<V> next;
        Node<V> previous;

        public Node(V value) {
            this.value = value;
        }
    }
}
