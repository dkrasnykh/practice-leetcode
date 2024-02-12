package main

func totalFruit(fruits []int) int {
	baskets := map[int]int{}
	update := func(res int) int {
		tmp := 0
		for _, v := range baskets {
			tmp += v
		}
		return max(res, tmp)
	}

	l, res := 0, 0
	for r := 0; r < len(fruits); r++ {
		_, ok := baskets[fruits[r]]
		if len(baskets) == 2 && !ok {
			res = update(res)
			for len(baskets) > 1 {
				baskets[fruits[l]] -= 1
				if baskets[fruits[l]] == 0 {
					delete(baskets, fruits[l])
				}
				l += 1
			}
		}
		baskets[fruits[r]] += 1
	}
	res = update(res)
	return res
}
