package main

// https://www.youtube.com/watch?v=I3lnDUIzIG4
func minimumFuelCost1(roads [][]int, seats int) int64 {
	numOfCars := func(p int) int64 {
		if p%seats != 0 {
			return int64(p/seats + 1)
		}
		return int64(p / seats)
	}
	adj := make(map[int][]int)
	for _, v := range roads {
		adj[v[0]] = append(adj[v[0]], v[1])
		adj[v[1]] = append(adj[v[1]], v[0])
	}
	var res int64
	var dfs func(node, parent int) int
	dfs = func(node, parent int) int {
		passengers := 0
		for _, child := range adj[node] {
			if child != parent {
				p := dfs(child, node)
				passengers += p
				res += numOfCars(p)
			}
		}
		return passengers + 1
	}
	dfs(0, -1)
	return res
}
