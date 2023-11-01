package trees.same_tree_100;

import java.util.ArrayDeque;
import java.util.Objects;

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

class Pair<F, S> {
    F first;
    S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

class Solution {
    private boolean isEqual(Pair<TreeNode, Boolean> p1, Pair<TreeNode, Boolean> p2) {
        return p1.first.val == p2.first.val && p1.second == p2.second;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        ArrayDeque<Pair<TreeNode, Boolean>> q1 = new ArrayDeque<>();
        ArrayDeque<Pair<TreeNode, Boolean>> q2 = new ArrayDeque<>();
        q1.addLast(new Pair<>(p, true));
        q2.addLast(new Pair<>(q, true));
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.size() != q2.size()) {
                return false;
            }
            int lenght = q1.size();
            for (int i = 0; i < lenght; ++i) {
                Pair<TreeNode, Boolean> p1 = q1.pollFirst();
                Pair<TreeNode, Boolean> p2 = q2.pollFirst();
                if (!isEqual(p1, p2)) {
                    return false;
                }
                if (p1.first.left != null) {
                    q1.addLast(new Pair<>(p1.first.left, true));
                }
                if (p1.first.right != null) {
                    q1.addLast(new Pair<>(p1.first.right, false));
                }
                if (p2.first.left != null) {
                    q2.addLast(new Pair<>(p2.first.left, true));
                }
                if (p2.first.right != null) {
                    q2.addLast(new Pair<>(p2.first.right, false));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
