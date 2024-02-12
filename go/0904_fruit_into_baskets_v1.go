package main

func totalFruit1(fruits []int) int {
	count := map[int]int{}
	left, total, res := 0, 0, 0

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for _, fruit := range fruits {
		count[fruit]++
		total++

		for len(count) > 2 {
			f := fruits[left]
			count[f]--
			total--
			left++
			if count[f] == 0 {
				delete(count, f)
			}
		}
		res = max(res, total)
	}
	return res
}
