package main

import "sort"

func findClosestElements(arr []int, k int, x int) []int {
	l, r := 0, len(arr)-1
	for l <= r {
		m := l + (r-l)/2
		if arr[m] < x {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	abs := func(n int) int {
		if n < 0 {
			return -n
		}
		return n
	}
	res := []int{}
	r = l
	l = r - 1
	for k > 0 {
		if r == len(arr) || abs(arr[l]-x) <= abs(arr[r]-x) {
			res = append(res, arr[l])
			l -= 1
		} else {
			res = append(res, arr[r])
			r += 1
		}
		k -= 1
	}
	sort.Ints(res)
	return res
}
