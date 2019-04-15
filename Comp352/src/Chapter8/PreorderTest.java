package Chapter8;

public class PreorderTest {
    public static void main(String[] args) {
        PreorderTestTree<Integer> tree = new PreorderTestTree<>();
        PreorderTestTree<Integer>.TreeNode<Integer> root = tree.addRoot(5);
        PreorderTestTree<Integer>.TreeNode<Integer> node3 = tree.addLeft(root, 3);
        PreorderTestTree<Integer>.TreeNode<Integer> node9 = tree.addRight(root, 9);
        PreorderTestTree<Integer>.TreeNode<Integer> node2 = tree.addLeft(node3, 2);
        PreorderTestTree<Integer>.TreeNode<Integer> node4 = tree.addRight(node3, 4);
        PreorderTestTree<Integer>.TreeNode<Integer> node7 = tree.addLeft(node9, 7);

        tree.preorder(root);
    }
}
