package main

import "container/heap"

func findKthLargest(nums []int, k int) int {
	h := &MaxHeap{}
	heap.Init(h)
	for i := 0; i < len(nums); i++ {
		heap.Push(h, nums[i])
	}
	var ans int
	for k > 0 {
		ans = heap.Pop(h).(int)
		k -= 1
	}
	return ans
}
