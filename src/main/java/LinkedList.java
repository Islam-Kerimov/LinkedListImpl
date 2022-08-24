public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int count;

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);

        if (count == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        count++;
    }

    private static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }
}
