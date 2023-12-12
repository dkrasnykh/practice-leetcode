package main

import "fmt"

func closestMeetingNode1(edges []int, node1 int, node2 int) int {
	adj := make([][]int, len(edges))
	for i := 0; i < len(edges); i++ {
		adj[i] = append(adj[i], edges[i])
	}

	bfs := func(src int, distMap map[int]int) {
		q := make([][2]int, 0)
		q = append(q, [...]int{src, 0})
		distMap[src] = 0
		for len(q) > 0 {
			node, dist := q[0][0], q[0][1]
			q = q[1:]
			for _, nei := range adj[node] {
				if _, ok := distMap[nei]; !ok {
					q = append(q, [...]int{nei, dist + 1})
					distMap[nei] = dist + 1
				}
			}
		}
	}
	node1Dist := make(map[int]int)
	node2Dist := make(map[int]int)
	bfs(node1, node1Dist)
	bfs(node2, node2Dist)
	res := -1
	resDist := 2000000

	for i := 0; i < len(edges); i++ {
		_, ok1 := node1Dist[i]
		_, ok2 := node2Dist[i]
		if ok1 && ok2 {
			dist := max(node1Dist[i], node2Dist[i])
			if dist < resDist {
				res = i
				resDist = dist
			}
		}
	}
	return res
}

func main() {
	edges := []int{4, 4, 8, -1, 9, 8, 4, 4, 1, 1}
	fmt.Println(closestMeetingNode1(edges, 5, 6))
}
