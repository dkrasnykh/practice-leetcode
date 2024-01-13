package main

func leastBricks1(wall [][]int) int {
	m := map[int]int{}
	maxEnds := 0
	for i := 0; i < len(wall); i++ {
		b := 0
		for j := 0; j < len(wall[i])-1; j++ {
			b += wall[i][j]
			m[b] += 1
			maxEnds = max(maxEnds, m[b])
		}
	}
	return len(wall) - maxEnds
}
