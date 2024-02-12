package main

func arrangeCoins(n int) int {
	l, r := 1, n
	for l <= r {
		m := l + (r-l)/2
		if (1+m)*m/2 < n {
			l = m + 1
		} else if (1+m)*m/2 > n {
			r = m - 1
		} else {
			return m
		}
	}
	return r
}
