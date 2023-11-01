package trees.construct_quad_tree_427;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class Solution {
    private int getValue(int[][] grid, int r1, int c1, int r2, int c2) {
        int value = grid[r1][c1];
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                if (grid[i][j] != value) {
                    return -1;
                }
            }
        }
        return value;
    }

    private Node dfs(int[][] grid, int r1, int c1, int r2, int c2) {
        int value = getValue(grid, r1, c1, r2, c2);
        if (value != -1) {
            return new Node(value == 1, true);
        }
        Node node = new Node(true, false);
        //r1 c1 r2 c2
        node.topLeft = dfs(grid, r1, c1, r1 + (r2 - r1) / 2, c1 + (c2 - c1) / 2);
        node.topRight = dfs(grid, r1, c1 + (c2 - c1) / 2 + 1, r1 + (r2 - r1) / 2, c2);
        node.bottomLeft = dfs(grid, r1 + (r2 - r1) / 2 + 1, c1, r2, c1 + (c2 - c1) / 2);
        node.bottomRight = dfs(grid, r1 + (r2 - r1) / 2 + 1, c1 + (c2 - c1) / 2 + 1, r2, c2);
        return node;
    }

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length - 1, grid.length - 1);
    }
}

