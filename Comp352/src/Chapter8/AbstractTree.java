package Chapter8;

import Chapter6.LinkedQueue;
import Chapter6.Queue;
import Chapter7.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class AbstractTree<E> implements Tree<E> {
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() {
            posIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> positions() {
        return preorder();
    }

    public Iterable<Position<E>> preorder() {
        ArrayList<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for (Position<E> child : children(p)) {
            postorderSubtree(child, snapshot);
        }
        snapshot.add(p);
    }

    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(),snapshot);
        }
        return snapshot;
    }

    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c);
                }
            }
        }
        return snapshot;
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p){
        if (isRoot(p))
            return 0;
        else return 1 + depth(parent(p));
    }

    public int height(Position<E> p){
        int h = 0;
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }
}
