package main

import "sort"

func numRescueBoats1(people []int, limit int) int {
	sort.Ints(people)
	l, r := 0, len(people)-1
	res := 0
	for l <= r {
		remain := limit - people[r]
		r -= 1
		res += 1
		if l <= r && remain >= people[l] {
			l += 1
		}
	}
	return res
}
