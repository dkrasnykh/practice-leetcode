package main

func isPerfectSquare(num int) bool {
	l, r := 0, num/2
	for l <= r {
		m := l + (r-l)/2
		square := m * m
		if square < num {
			l = m + 1
		} else if square > num {
			r = m - 1
		} else {
			return true
		}
	}
	return false
}
