package main

import (
	"math/rand"
	"time"
)

func sortArray(nums []int) []int {
	rand.Seed(time.Now().UnixNano())

	partition := func(l int, r int) int {
		x := nums[r]
		for i := l; i <= r; i++ {
			if nums[i] <= x {
				nums[l], nums[i] = nums[i], nums[l]
				l += 1
			}
		}
		return l - 1
	}

	randomized := func(l, r int) int {
		i := l + rand.Intn(r-l+1)
		nums[i], nums[r] = nums[r], nums[i]
		return partition(l, r)
	}

	isSorted := func(p, r int) bool {
		for i := p + 1; i <= r; i++ {
			if nums[i] < nums[i-1] {
				return false
			}
		}
		return true
	}

	var quicksort func(p int, r int)
	quicksort = func(p int, r int) {
		if p < r && !isSorted(p, r) {
			//q := partition(p, r)
			q := randomized(p, r)
			quicksort(p, q-1)
			quicksort(q+1, r)
		}
	}
	quicksort(0, len(nums)-1)
	return nums
}
