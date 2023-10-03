package trees.serialize_and_deserialize_binary_tree_297;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

public class Codec {
    private void seriallizationDfs(List<String> path, TreeNode node){
        if(node == null){
            path.add("N");
            return;
        }
        path.add(Integer.toString(node.val));
        seriallizationDfs(path, node.left);
        seriallizationDfs(path, node.right);
    }
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        seriallizationDfs(res, root);
        return res.stream().collect(Collectors.joining(","));
    }
    private TreeNode deserializationDfs(String[] data, int[] ind){
        if(data[ind[0]].equals("N")){
            ind[0] += 1;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[ind[0]]));
        ind[0] += 1;
        root.left = deserializationDfs(data, ind);
        root.right = deserializationDfs(data, ind);
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserializationDfs(arr, new int[]{0});
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        node3.left = node4;
        node3.right = node5;
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        String data = codec.serialize(node1);
        System.out.println(data);
        TreeNode res = codec.deserialize(data);
        int test = 5;
    }
}
