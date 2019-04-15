package Chapter8;

import Chapter7.Position;

public class TextbookTreeTest {
    public static void main(String[] args) throws IllegalAccessException {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(5);
        Position<Integer> p3 = tree.addLeft(root, 3);
        Position<Integer> p9 = tree.addRight(root, 9);
        tree.addLeft(p3, 2);
        tree.addRight(p3, 4);
        tree.addLeft(p9, 7);
        Iterable<Position<Integer>> preorder = tree.preorder();
        for (Position<Integer> e : preorder) {
            System.out.print(e.getElement() + " ");
        }
    }
}
