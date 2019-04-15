package assignment.a3;

import java.util.Iterator;

public class LinkedHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    protected static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    protected Node<Entry<K,V>> root = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    public Iterator<Entry<K, V>> iterator() {
        return null;
    }

    public Iterable<Position<Entry<K, V>>> positions() {
        return null;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Entry<K, V> min() {
        return root.element;
    }

    @Override
    public Entry<K, V> removeMin() {
        return null;
    }
}
