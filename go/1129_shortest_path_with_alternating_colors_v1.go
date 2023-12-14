package main

//https://www.youtube.com/watch?v=69rcy6lb-HQ
func shortestAlternatingPaths1(n int, redEdges [][]int, blueEdges [][]int) []int {
	red := make(map[int][]int)
	blue := make(map[int][]int)
	for i := 0; i < len(redEdges); i++ {
		src := redEdges[i][0]
		dst := redEdges[i][1]
		red[src] = append(red[src], dst)
	}
	for i := 0; i < len(blueEdges); i++ {
		src := blueEdges[i][0]
		dst := blueEdges[i][1]
		blue[src] = append(blue[src], dst)
	}
	answer := make([]int, n)
	for i := 0; i < n; i++ {
		answer[i] = -1
	}
	q := make([][3]int, 0)
	q = append(q, [...]int{0, 0, 0}) //[node, length, prev_edge_color]
	visit := make(map[[2]int]bool)
	visit[[2]int{0, 0}] = true //[node, color]
	for len(q) > 0 {
		node, length, edgeColor := q[0][0], q[0][1], q[0][2]
		q = q[1:]
		if answer[node] == -1 {
			answer[node] = length
		}
		//1 - red, 2 - blue
		if edgeColor != 1 {
			for _, nei := range red[node] {
				if !visit[[2]int{nei, 1}] {
					visit[[2]int{nei, 1}] = true
					q = append(q, [3]int{nei, length + 1, 1})
				}
			}
		}

		if edgeColor != 2 {
			for _, nei := range blue[node] {
				if !visit[[2]int{nei, 2}] {
					visit[[2]int{nei, 2}] = true
					q = append(q, [3]int{nei, length + 1, 2})
				}
			}
		}
	}
	return answer
}
