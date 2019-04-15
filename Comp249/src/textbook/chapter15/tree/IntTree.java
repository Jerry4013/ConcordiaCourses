package chapter15.tree;

public class IntTree {
    private static class IntTreeNode{
        private int data;
        private IntTreeNode leftLink;
        private IntTreeNode rightLink;

        public IntTreeNode(int data, IntTreeNode leftLink, IntTreeNode rightLink){
            this.data = data;
            this.leftLink = leftLink;
            this.rightLink = rightLink;
        }
    }

    private IntTreeNode root;

    public IntTree(){
        root = null;
    }

    public void add(int item){
        root = insertInSubtree(item, root);
    }

    private static boolean isInSubtree(int item, IntTreeNode subTreeRoot){
        if (subTreeRoot == null)
            return false;
        else if (subTreeRoot.data == item)
            return true;
        else if (item < subTreeRoot.data)
            return isInSubtree(item, subTreeRoot.leftLink);
        else
            return isInSubtree(item, subTreeRoot.rightLink);
    }

    private static IntTreeNode insertInSubtree(int item, IntTreeNode subTreeRoot){
        if (subTreeRoot == null) {
            return new IntTreeNode(item, null, null);
        } else if (item < subTreeRoot.data) {
            subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
            return subTreeRoot;
        } else{
            subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
            return subTreeRoot;
        }
    }

    public boolean contains(int item){
        return isInSubtree(item, root);
    }

    private static void showElementsInSubtree(IntTreeNode subTreeRoot){
        if (subTreeRoot != null){
            showElementsInSubtree(subTreeRoot.leftLink);
            System.out.print(subTreeRoot.data + " ");
            showElementsInSubtree(subTreeRoot.rightLink);
        }
    }

    public void showElements( ){
        showElementsInSubtree(root);
    }

}
