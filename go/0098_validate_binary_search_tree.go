package main

func isValidBST(root *TreeNode) bool {
	var dfs func(node *TreeNode, maxValue, minValue int64) bool
	dfs = func(node *TreeNode, maxValue, minValue int64) bool {
		if node == nil {
			return true
		}
		return int64(node.Val) > minValue &&
			int64(node.Val) < maxValue &&
			dfs(node.Left, int64(node.Val), minValue) &&
			dfs(node.Right, maxValue, int64(node.Val))
	}
	return dfs(root, 4294967296, -4294967296)
}
