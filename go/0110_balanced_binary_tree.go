package main

func isBalanced(root *TreeNode) bool {
	abs := func(n int) int {
		if n < 0 {
			return -n
		}
		return n
	}
	var dfs func(node *TreeNode) (int, bool)
	dfs = func(node *TreeNode) (int, bool) {
		if node == nil {
			return 0, true
		}
		lh, lb := dfs(node.Left)
		rh, rb := dfs(node.Right)
		return 1 + max(lh, rh), lb && rb && abs(lh-rh) <= 1
	}
	_, ans := dfs(root)
	return ans
}
