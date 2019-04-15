package chapter15.textBookTest;

public class IntTree {

    private static class IntTreeNode{
        private int data;
        private IntTreeNode leftLink;
        private IntTreeNode rightLink;

        public IntTreeNode(){}
        public IntTreeNode(int data, IntTreeNode leftLink, IntTreeNode rightLink) {
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
    public boolean contains(int item){
        return isInSubtree(item, root);
    }
    public void showElements(){
        showElementsInSubtree(root);
    }

    private static IntTreeNode insertInSubtree(int item, IntTreeNode subTreeRoot){
        if(subTreeRoot==null)
            return new IntTreeNode(item, null, null);
        else if (item<subTreeRoot.data){
            subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
            return subTreeRoot;
        }
        else{
            subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
            return subTreeRoot;
        }
    }

    private static boolean isInSubtree(int item, IntTreeNode subtreeRoot){
        if(subtreeRoot==null)
            return false;
        else if(item == subtreeRoot.data)
            return true;
        else if(item < subtreeRoot.data)
            return isInSubtree(item, subtreeRoot.leftLink);
        else
            return isInSubtree(item, subtreeRoot.rightLink);
    }

    private static void showElementsInSubtree(IntTreeNode subTreeRoot){
        if(subTreeRoot!=null){
            showElementsInSubtree(subTreeRoot.leftLink);
            System.out.println(subTreeRoot.data + " ");
            showElementsInSubtree(subTreeRoot.rightLink);
        }
    }


}
