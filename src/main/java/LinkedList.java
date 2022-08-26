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

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public boolean delete(E element) {
        if (first == null) {
            return false;
        }
//        if (size == 1 && getFirst().equals(element)) {
//            return deleteLink(first);
//        } else if (size == 1 && !getFirst().equals(element)) {
//            return false;
//        }

        if (getLast().equals(element)) {
            return deleteLink(last);
        } else if (getFirst().equals(element)) {
            return deleteLink(first);
        } else {
            for (Node<E> current = first; current != last; current = current.next) {
                if (current.value.equals(element)) {
                    return deleteLink(current);
                }
            }
        }

        return false;
    }

    private boolean deleteLink(Node<E> current) {
        if (size == 1) {
            first = null;
            last = null;
        } else if (current == last) {
            Node<E> temp = last;
            last = last.previous;
            last.next = null;
            temp.previous = null;
        } else if (current == first) {
            Node<E> temp = first;
            first = first.next;
            first.previous = null;
            temp.next = null;
        } else {
            Node<E> previous = current.previous;
            Node<E> next = current.next;

            previous.next = next;
            next.previous = previous;
            current.next = null;
            current.previous = null;
        }

        size--;
        return true;
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
