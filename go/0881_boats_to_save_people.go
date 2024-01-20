package main

import "sort"

func numRescueBoats(people []int, limit int) int {
	sort.Ints(people)
	l, r := 0, len(people)-1
	res := 0
	for true {
		for l <= r && people[l]+people[r] > limit {
			res += 1
			r -= 1
		}
		if l > r {
			break
		}
		res += 1
		l += 1
		r -= 1
	}
	return res
}
