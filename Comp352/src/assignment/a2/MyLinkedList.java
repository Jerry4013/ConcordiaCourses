package assignment.a2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E>, Cloneable {

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node() {
            this(null, null, null);
        }

        public Node(E e, Node<E> p, Node<E> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public MyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    @Override
    public boolean add(E e) {
        addBetween(e, trailer.getPrev(), trailer);
        return true;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        Node<E> position = header;
        for (int i = 0; i < index; i++) {
            position = position.next;
        }
        addBetween(element, position, position.next);
    }

    @Override
    public void clear() {
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        if (index == size - 1){
            E temp = trailer.prev.element;
            trailer.prev.prev.setNext(trailer);
            trailer.setPrev(trailer.prev.prev);
            size--;
            return temp;
        }
        Node<E> position = header;
        for (int i = 0; i <= index; i++) {
            position = position.next;
        }
        E temp = position.element;
        position.prev.setNext(position.next);
        position.next.setPrev(position.prev);
        size--;
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> position = header;
        while (position != trailer) {
            if (o.equals(position.element)) {
                position.prev.setNext(position.next);
                position.next.setPrev(position.prev);
                size--;
                return true;
            }
            position = position.next;
        }
        return false;
    }

    @Override
    public String toString() {
        Node<E> position = header.next;
        StringBuilder temp = new StringBuilder();
        temp.append("[");
        while (position != trailer) {
            temp.append(position.element);
            if (position != trailer.prev) {
                temp.append(", ");
            }
            position = position.next;
        }
        temp.append("]");
        return temp.toString();
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index, int n) throws IndexOutOfBoundsException {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    private Node<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
