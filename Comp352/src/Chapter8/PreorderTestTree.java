package Chapter8;

public class PreorderTestTree<E> {
    public class TreeNode<E> {
        private E element;
        private TreeNode<E> parent;
        private TreeNode<E> left;
        private TreeNode<E> right;

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public TreeNode<E> getParent() {
            return parent;
        }

        public void setParent(TreeNode<E> parent) {
            this.parent = parent;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }

        public TreeNode(E element, TreeNode<E> parent, TreeNode<E> left, TreeNode<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode<E> addRoot(E e) {
        root = new TreeNode<>(e, null, null, null);
        this.size = 1;
        return root;
    }

    private TreeNode<E> root;
    private int size = 0;

    public TreeNode<E> getRoot(){
        return root;
    }

    public TreeNode<E> addLeft(TreeNode<E> node, E e){
        node.left = new TreeNode<>(e, node, null, null);
        size++;
        return node.left;
    }
    public TreeNode<E> addRight(TreeNode<E> node, E e){
        node.right = new TreeNode<>(e, node, null, null);
        size++;
        return node.right;
    }

    public void preorder(TreeNode<E> node){
        if (node != null){

            preorder(node.left);

            preorder(node.right);
            System.out.print(node.element + " ");
        }
    }
}
