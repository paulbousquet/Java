import java.util.*;

public class TreeSort {
    public int[] sort(TreeNode tree) {
        ArrayList pie = new ArrayList();
        inOrder(tree,pie);
        int[] plain = new int[pie.size()];
        int fork = 0;
        Object[] fink = pie.toArray();
        Arrays.sort(fink);
        for (Object f:fink){
            plain[fork] = Integer.parseInt(f.toString());
            fork += 1;
        }
        return plain;
    }
    public void inOrder(TreeNode root, ArrayList mySet){
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