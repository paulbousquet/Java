public class LevelCount {
    public int count(TreeNode t, int level) {
        if (t == null) {
            return 0;
        }

        if (level == 0) {
            return 1;
        }

        int nodeCount = 0;

        nodeCount += count(t.left, level - 1);
        nodeCount += count(t.right,level - 1);

        return nodeCount;
    }
}