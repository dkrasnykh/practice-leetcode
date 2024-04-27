package main

func minDiffInBST(root *TreeNode) int {
	var prev *TreeNode
	res := 1000000
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Left)
		if prev != nil {
			res = min(res, node.Val-prev.Val)
		}
		prev = node
		dfs(node.Right)
	}
	dfs(root)
	return res
}
