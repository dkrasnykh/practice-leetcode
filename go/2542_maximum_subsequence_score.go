package main

import (
	"container/heap"
	"sort"
)

func maxScore(nums1 []int, nums2 []int, k int) int64 {
	nums := make([][2]int, len(nums1))
	for i := 0; i < len(nums1); i++ {
		nums[i] = [...]int{nums1[i], nums2[i]}
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i][1] > nums[j][1]
	})
	var res, n1Sum int64
	h := &IntHeap{}
	heap.Init(h)

	for i := 0; i < len(nums); i++ {
		n1 := nums[i][0]
		n2 := nums[i][1]
		n1Sum += int64(n1)
		heap.Push(h, n1)
		if len(*h) > k {
			n1Pop := heap.Pop(h).(int)
			n1Sum -= int64(n1Pop)
		}
		if len(*h) == k {
			res = max(res, int64(n2)*n1Sum)
		}
	}
	return res
}
