package main

//TL when n==100
func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	adj := make([][][2]int, n)
	for i := 0; i < len(redEdges); i++ {
		ai, bi := redEdges[i][0], redEdges[i][1]
		adj[ai] = append(adj[ai], [2]int{bi, 1})
	}
	for i := 0; i < len(blueEdges); i++ {
		ui, vi := blueEdges[i][0], blueEdges[i][1]
		adj[ui] = append(adj[ui], [2]int{vi, 2})
	}
	result := make([]int, n)
	for i := 0; i < n; i++ {
		result[i] = -1
	}
	used := make(map[[2]int]struct{})
	var dfs func(v, c, path int)
	dfs = func(v, c, path int) {
		if result[v] == -1 || result[v] > path {
			result[v] = path
		}
		used[[2]int{v, c}] = struct{}{}
		for i := 0; i < len(adj[v]); i++ {
			u := adj[v][i][0]
			nc := adj[v][i][1]
			_, ok := used[[2]int{u, nc}]
			if nc == 3-c && !ok {
				dfs(u, nc, path+1)
			}
		}
		delete(used, [2]int{v, c})
	}
	dfs(0, 1, 0)
	dfs(0, 2, 0)
	return result
}
