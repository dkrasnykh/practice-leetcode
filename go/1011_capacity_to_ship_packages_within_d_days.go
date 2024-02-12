package main

func shipWithinDays(weights []int, days int) int {
	l, r := 0, 0
	for i := 0; i < len(weights); i++ {
		l = max(l, weights[i])
		r += weights[i]
	}
	check := func(cap int) bool {
		d, total := 1, 0
		for i := 0; i < len(weights); i++ {
			if total+weights[i] > cap {
				d += 1
				total = weights[i]
			} else {
				total += weights[i]
			}
		}
		return d <= days
	}
	for l <= r {
		m := l + (r-l)/2
		if !check(m) {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return l
}
