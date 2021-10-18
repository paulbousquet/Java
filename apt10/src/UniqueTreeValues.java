import java.util.*;
public class UniqueTreeValues {
    public int[] unique(TreeNode root) {
        Set<Integer> pie = new TreeSet<>();
        inOrder(root, pie);
        int[] plain = new int[pie.size()];
        int fit = 0;
        for (int k:pie){
            plain[fit] = k;
            fit+=1;
        }
        return plain;
    }
    public void inOrder(TreeNode root, Set<Integer> mySet){
        if (root!=null){
            inOrder(root.left, mySet);
            mySet.add(root.info);
            inOrder(root.right, mySet);
        }
    }
    private class TreeIterator implements Iterator<Integer> {
        private Stack<TreeNode> myStack;

        public TreeIterator(TreeNode root) {
            myStack = new Stack<>();
            while (root != null) {
                myStack.push(root);
                root = root.left;
            }
        }

        @Override
        public boolean hasNext() {
            return myStack.size() > 0;
        }

        @Override
        public Integer next() {
            TreeNode t = myStack.pop();
            int data = t.info;
            findSuccessor(t);
            return data;
        }

        private void findSuccessor(TreeNode t) {
            if (t == null)
                return;               // no successor
            if (t.right != null) {    // has a right child
                t = t.right;
                while (t != null) {
                    myStack.push(t);
                    t = t.left;
                }
            }
        }
    }
}
