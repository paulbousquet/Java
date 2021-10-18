import java.util.*;
public class LeafCollector {
    public String[] getLeaves(TreeNode tree) {
        traverse(tree);
        for (Integer k:map.keySet()){
            fork.add(String.join(" ",map.get(k)));
        }
        return fork.toArray(new String[0]);
    }

    private int height(TreeNode root){
        if (root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    private TreeNode traverse(TreeNode t){
        map.putIfAbsent(height(t), new ArrayList<>());
        map.get(height(t)).add(""+t.info);
        if (t.left!=null) traverse(t.left);
        if (t.right!=null) traverse(t.right);
        return t;
    }
    TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
    ArrayList<String> fork = new ArrayList<>();

}