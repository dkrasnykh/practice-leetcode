package main

func isBipartite(graph [][]int) bool {
	n := len(graph)
	color := make([]int, n)
	var dfs func(v, c int) bool
	dfs = func(v, c int) bool {
		color[v] = c
		res := true
		for _, u := range graph[v] {
			if color[u] == 0 {
				res = dfs(u, 3-c) && res
			} else if color[u] == c {
				return false
			}
		}
		return res
	}
	for i := 0; i < n; i++ {
		if color[i] == 0 && !dfs(i, 1) {
			return false
		}
	}
	return true
}
