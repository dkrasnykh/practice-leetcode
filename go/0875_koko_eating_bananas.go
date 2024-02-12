package main

func minEatingSpeed(piles []int, h int) int {
	l, r := 1, 0
	for _, pile := range piles {
		r = max(r, pile)
	}
	check := func(k int) bool {
		cnt := 0
		for i := 0; i < len(piles); i++ {
			cnt += piles[i] / k
			if piles[i]%k > 0 {
				cnt += 1
			}
		}
		return cnt <= h
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
