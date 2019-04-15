package Chapter8;

import java.util.ArrayList;
import java.util.List;
import Chapter7.Position;


public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
                                            implements BinaryTree<E> {

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) return null;
        if (p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int counter = 0;
        if (left(p) != null){
            counter++;
        }
        if (right(p) != null){
            counter++;
        }
        return counter;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }

    public Iterable<Position<E>> inorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    public Iterable<Position<E>> positions(){
        return inorder();
    }
}
