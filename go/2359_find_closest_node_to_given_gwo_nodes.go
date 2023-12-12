package main

func closestMeetingNode(edges []int, node1 int, node2 int) int {
	n := len(edges)
	inf := 1000000
	used1 := make([]bool, n)
	used2 := make([]bool, n)
	path1 := make(map[int]struct{})
	path2 := make(map[int]struct{})

	d1 := make([]int, n)
	for i := 0; i < n; i++ {
		d1[i] = inf
	}
	d2 := make([]int, n)
	for i := 0; i < n; i++ {
		d2[i] = inf
	}

	d := 0
	for node1 != -1 && !used1[node1] {
		d1[node1] = d
		d += 1
		path1[node1] = struct{}{}
		used1[node1] = true
		node1 = edges[node1]
	}
	d = 0
	for node2 != -1 && !used2[node2] {
		d2[node2] = d
		d += 1
		path2[node2] = struct{}{}
		used2[node2] = true
		node2 = edges[node2]
	}
	mind := 2 * inf
	minn := -1

	for i := 0; i < n; i++ {
		if d1[i] != inf && d2[i] != inf && mind > max(d1[i], d2[i]) {
			mind = max(d1[i], d2[i])
			minn = i
		}
	}

	return minn
}
