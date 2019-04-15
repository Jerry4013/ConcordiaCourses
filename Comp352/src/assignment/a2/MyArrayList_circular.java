package assignment.a2;

import java.util.*;

public class MyArrayList_circular<E> implements List<E> {

    public static final int CAPACITY=16;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public MyArrayList_circular() {
        this(CAPACITY);
    }

    public MyArrayList_circular(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public boolean add(E e) {
        if (size == data.length){
            resize(2 * size);
        }
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (size == data.length){
            resize(2 * size);
        }
        if (index == 0) {
            f = (f - 1 + data.length) % data.length;
            data[f] = element;
        }else {
            for (int i = 0; i < size - index ; i++) {
                int last = (f + size - 1 + data.length) % data.length;
                data[(last - i + 1 + data.length) % data.length] =
                        data[(last - i + data.length) % data.length];
            }
            data[(f + index) % data.length] = element;
        }
        size++;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
        f = 0;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E temp = data[(f + index) % data.length];
        for (int i = 0; i < size - index - 1; i++) {
            data[(f + index + i) % data.length] = data[(f + 1 + index + i) % data.length];
        }
        data[(f + size - 1) % data.length ] = null;
        size--;
        if (size <= data.length / 4){
            resize(data.length / 2);
        }
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[(f + i) % data.length].equals(o)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
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

    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            temp[i] = data[(f + i) % size];
        data = temp;
        f = 0;
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
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
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
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }
}
