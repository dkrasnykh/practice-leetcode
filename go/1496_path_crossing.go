package main

func isPathCrossing(path string) bool {
	cur := [...]int{0, 0}
	v := map[[2]int]bool{cur: true}
	for i := 0; i < len(path); i++ {
		switch path[i] {
		case byte('N'):
			cur[1] += 1
		case byte('E'):
			cur[0] += 1
		case byte('S'):
			cur[1] -= 1
		case byte('W'):
			cur[0] -= 1
		}
		if v[cur] {
			return true
		}
		v[cur] = true
	}
	return false
}
