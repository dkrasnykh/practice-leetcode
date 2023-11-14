package main

func findRedundantConnection(edges [][]int) []int {
	n := len(edges)
	adj := make([][]int, n+1)
	for i := 0; i < n; i++ {
		adj[edges[i][0]] = append(adj[edges[i][0]], int(edges[i][1]))
		adj[edges[i][1]] = append(adj[edges[i][1]], int(edges[i][0]))
	}
	used := make([]bool, n+1)
	p := make([]int, n+1)
	s, f := -1, -1
	var dfs func(v int, last int)

	dfs = func(v int, last int) {
		used[v] = true
		for _, u := range adj[v] {
			if used[u] && u != last {
				if s == -1 {
					s = u
					f = v
				}
				return
			} else if !used[u] {
				p[u] = v
				dfs(u, v)
			}
		}
	}
	dfs(1, 1)
	cycleElem := make(map[int]struct{})
	for v := f; v != s; v = p[v] {
		cycleElem[v] = struct{}{}
	}
	cycleElem[s] = struct{}{}
	for j := n - 1; j >= 0; j-- {
		_, ok1 := cycleElem[edges[j][0]]
		_, ok2 := cycleElem[edges[j][1]]
		if ok1 && ok2 {
			return edges[j]
		}
	}
	return []int{}
}
