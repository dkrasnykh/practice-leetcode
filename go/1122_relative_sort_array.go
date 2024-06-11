package main

import "sort"

func relativeSortArray(arr1 []int, arr2 []int) []int {
	res := make([]int, 0, len(arr1))
	arr1_cnt := make(map[int]int)
	arr2_set := map[int]bool{}

	for _, n := range arr2 {
		arr2_set[n] = true
	}

	tail := []int{}

	for _, n := range arr1 {
		if !arr2_set[n] {
			tail = append(tail, n)
			continue
		}
		arr1_cnt[n] += 1
	}
	sort.Ints(tail)

	for _, n := range arr2 {
		for i := 0; i < arr1_cnt[n]; i++ {
			res = append(res, n)
		}
	}

	res = append(res, tail...)
	return res
}
