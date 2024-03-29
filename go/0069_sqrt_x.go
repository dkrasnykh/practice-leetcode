package main

func mySqrt(x int) int {
	l, r := 0, max(x/2, 1)
	for l <= r {
		m := l + (r-l)/2
		if m*m < x {
			l = m + 1
		} else if m*m > x {
			r = m - 1
		} else {
			return m
		}
	}
	return r
}
