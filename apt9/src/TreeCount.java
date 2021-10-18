import java.util.*;

public class TreeCount {
    public int count(TreeNode tree) {
        Iterator<Integer> foke = new TreeIterator(tree);
        int pie = 0;
        while (foke.hasNext()){
            pie += 1;
            foke.next();
        }
        return pie;
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