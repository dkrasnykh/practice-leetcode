package main

func distributeCoins(root *TreeNode) int {
	res := 0

	abs := func(n int) int {
		if n < 0 {
			return -n
		}
		return n
	}

	var dfs func(cur *TreeNode) (int, int)
	dfs = func(cur *TreeNode) (int, int) {
		if cur == nil {
			return 0, 0 //size, coins
		}
		l_size, l_coins := dfs(cur.Left)
		r_size, r_coins := dfs(cur.Right)

		size := 1 + l_size + r_size
		coins := cur.Val + l_coins + r_coins

		res += abs(size - coins)

		return size, coins
	}
	dfs(root)
	return res
}
