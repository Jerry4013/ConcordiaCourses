package assignment.a2;

import java.util.*;

public class MyArrayList<E> implements List<E>, Cloneable {

    public static final int CAPACITY=16;
    private E[] data;
    private int size = 0;

    /**
     * Constructor, create a new List using the default Capacity, 16
     */
    public MyArrayList() {
        this(CAPACITY);
    }

    /**
     * Constructor, create a new List using the given Capacity as length
     * @param capacity
     */
    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * add an element e at the end of the list.
     * @param e the element to be added in the list
     * @return return true if adding successfully
     */
    @Override
    public boolean add(E e) {
        if (size == data.length){
            resize(2 * size);
        }
        data[size] = e;
        size++;
        return true;
    }

    /**
     * add an element at a specific index in the list
     * @param index the index where need to add the element
     * @param element the element to be added in the list
     * @throws IndexOutOfBoundsException when the index in the parameter is invalid
     */
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (size == data.length){
            resize(2 * size);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * clear this list keeping the length. Change every element to null
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * changePriority the element in the specific index of the list
     * @param index the index where to changePriority the element
     * @return return the element that is removed
     * @throws IndexOutOfBoundsException when the index in the parameter is invalid
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E temp = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size-1] = null;
        size--;
        if (size <= data.length / 4){
            resize(data.length / 2);
        }
        return temp;
    }

    /**
     * changePriority Removes the first occurrence of the specified element from this list
     * @param o the element to be removed
     * @return return true if an element is removed successfully.
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Convert the list to String
     * @return return the string
     */
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    /**
     * Returns the number of elements in this list
     * @return Returns the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * helper method. Check if the index given in the parameter is valid or not
     * @param index the index to be checked
     * @param n the upper bound of the valid indices
     * @throws IndexOutOfBoundsException the index is not valid
     */
    private void checkIndex(int index, int n) throws IndexOutOfBoundsException {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    /**
     * helper method. Change the length of the list and copy all the data from the original
     * list to the new list.
     * @param capacity the new length of the list
     */
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            temp[i] = data[i];
        data = temp;
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
