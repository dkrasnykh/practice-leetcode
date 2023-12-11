package main

func openLock(deadends []string, target string) int {
	dd := make(map[string]bool)
	for _, w := range deadends {
		dd[w] = true
	}
	visited := make(map[string]bool)
	q := make([]string, 0)
	ans := 0
	q = append(q, "0000")
	visited["0000"] = true
	for len(q) > 0 {
		size := len(q)
		for i := 0; i < size; i++ {
			e := q[0]
			if e == target {
				return ans
			}
			q = q[1:]
			if dd[e] {
				continue
			}
			tmp := make([]byte, len(e))
			copy(tmp, e)
			for j := 0; j < len(tmp); j++ {
				curr := tmp[j]
				if curr == 48 {
					tmp[j] = 57
				} else {
					tmp[j] -= 1
				}
				if !visited[string(tmp)] {
					q = append(q, string(tmp))
					visited[string(tmp)] = true
				}
				tmp[j] = curr
				if curr == 57 {
					tmp[j] = 48
				} else {
					tmp[j] += 1
				}
				if !visited[string(tmp)] {
					q = append(q, string(tmp))
					visited[string(tmp)] = true
				}
				tmp[j] = curr
			}
		}
		ans += 1
	}
	return -1
}
