package main

func minTime(n int, edges [][]int, hasApple []bool) int {
	adj := make([][]int, n)
	for _, v := range edges {
		a, b := v[0], v[1]
		adj[a] = append(adj[a], b)
		adj[b] = append(adj[b], a)
	}
	var dfs func(cur, par int) int
	dfs = func(cur, par int) int {
		time := 0
		for _, child := range adj[cur] {
			if child == par {
				continue
			}
			childTime := dfs(child, cur)
			if childTime > 0 || hasApple[child] {
				time += (2 + childTime)
			}
		}
		return time
	}
	return dfs(0, -1)
}

/*
func main() {

			n := 7
			edges := [][]int{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}
			hasApple := []bool{false, false, true, false, true, true, false}
			fmt.Println(minTime(n, edges, hasApple)) //8

		n := 7
		edges := [][]int{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}
		hasApple := []bool{false, false, false, false, false, false, false}
		fmt.Println(minTime(n, edges, hasApple)) //0

	n := 4
	edges := [][]int{{0, 2}, {0, 3}, {1, 2}}
	hasApple := []bool{false, true, false, false}
	fmt.Println(minTime(n, edges, hasApple))

}
*/
