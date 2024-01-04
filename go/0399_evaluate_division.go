package main

type Pair struct {
	v string
	w float64
}

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	adj := make(map[string][]Pair)
	for i := 0; i < len(equations); i++ {
		a := equations[i][0]
		b := equations[i][1]
		adj[a] = append(adj[a], Pair{b, values[i]})
		adj[b] = append(adj[b], Pair{a, 1 / values[i]})
	}
	visited := make(map[string]bool)
	var bfs func(v, target string) float64
	bfs = func(v, target string) float64 {
		q := make([]Pair, 0)
		q = append(q, Pair{v: v, w: 1.0})
		for len(q) > 0 {
			u := q[0]
			q = q[1:]
			visited[u.v] = true
			for _, p := range adj[u.v] {
				if p.v == target {
					return u.w * p.w
				}
				if visited[p.v] {
					continue
				}
				q = append(q, Pair{v: p.v, w: u.w * p.w})
			}
		}
		return -1
	}
	output := make([]float64, 0)
	for _, que := range queries {
		c := que[0]
		d := que[1]
		visited = make(map[string]bool)
		res := bfs(c, d)
		output = append(output, res)
	}
	return output
}
