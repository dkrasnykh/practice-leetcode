package main

func goodNodes(root *TreeNode) int {
	result := 0
	var dfs func(node *TreeNode, maxValue int)
	dfs = func(node *TreeNode, maxValue int) {
		if node == nil {
			return
		}
		if node.Val >= maxValue {
			result += 1
		}
		maxValue = max(maxValue, node.Val)
		dfs(node.Left, maxValue)
		dfs(node.Right, maxValue)
	}
	dfs(root, root.Val)
	return result
}

/*
neetcode.io

func goodNodes(root *TreeNode) int {
    return goodNodesUtil(root, root.Val)
}

func goodNodesUtil(root *TreeNode, parent int) int {
    if root == nil {
        return 0
    }

    res := 1
    max := root.Val

    if parent > root.Val {
        res = 0
        max = parent
    }

    res += goodNodesUtil(root.Left, max)
    res += goodNodesUtil(root.Right, max)

    return res
}
*/
