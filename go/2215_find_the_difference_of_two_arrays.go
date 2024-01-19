package main

import (
	"sort"
)

func diff(nums1, nums2 []int) []int {
	i, j := 0, 0
	d := []int{}
	for i < len(nums1) {
		if j == len(nums2) || nums1[i] < nums2[j] {
			d = append(d, nums1[i])
			i += 1
		} else if nums1[i] > nums2[j] {
			j += 1
		} else {
			j += 1
			i += 1
		}
		for i > 0 && i < len(nums1) && nums1[i-1] == nums1[i] {
			i += 1
		}
	}
	return d
}

func findDifference(nums1 []int, nums2 []int) [][]int {
	sort.Slice(nums1, func(i, j int) bool {
		return nums1[i] < nums1[j]
	})
	sort.Slice(nums2, func(i, j int) bool {
		return nums2[i] < nums2[j]
	})
	return [][]int{diff(nums1, nums2), diff(nums2, nums1)}
}
