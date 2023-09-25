package trees.find_duplicate_subtrees_652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private String dfs(TreeNode node, Map<String, List<TreeNode>> subtrees, List<TreeNode> result){
        if(node == null){
            return "null";
        }
        String s = Integer.toString(node.val).concat(",")
                .concat(dfs(node.left, subtrees, result)).concat(",")
                .concat(dfs(node.right, subtrees, result));
        if (subtrees.containsKey(s) && subtrees.get(s).size() == 1){
            result.add(node);
        }
        if(subtrees.containsKey(s)){
            subtrees.get(s).add(node);
        } else {
            subtrees.put(s, new ArrayList<>(List.of(node)));
        }
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> subtrees = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        dfs(root, subtrees, result);
        return result;
    }

    public static void main(String[] args) {

    }
}
