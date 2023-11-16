package main

func findCircleNum(isConnected [][]int) int {
	n := len(isConnected)
	adj := make([][]int, n)
	for i := 0; i < n; i++ {
		adj[i] = make([]int, 0)
	}
	used := make([]bool, n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i != j && isConnected[i][j] == 1 {
				adj[i] = append(adj[i], j)
			}
		}
	}

	var dfs func(v int)
	dfs = func(v int) {
		used[v] = true
		for _, u := range adj[v] {
			if !used[u] {
				dfs(u)
			}
		}
	}
	res := 0
	for i := 0; i < n; i++ {
		if !used[i] {
			dfs(i)
			res += 1
		}
	}
	return res
}
