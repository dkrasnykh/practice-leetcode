package main

func hasPathSum(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}
	var dfs func(node *TreeNode, currSum int) bool
	dfs = func(node *TreeNode, currSum int) bool {
		if node == nil {
			return false
		}
		if node.Left == nil && node.Right == nil {
			return currSum+node.Val == targetSum
		}
		if dfs(node.Left, currSum+node.Val) {
			return true
		}
		if dfs(node.Right, currSum+node.Val) {
			return true
		}
		return false
	}
	return dfs(root, 0)
}
