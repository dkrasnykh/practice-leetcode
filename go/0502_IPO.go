package main

import (
	"container/heap"
	"sort"
)

func findMaximizedCapital(k int, w int, profits []int, capital []int) int {
	q := make([][]int, 0, len(capital))
	for i := 0; i < len(capital); i++ {
		q = append(q, []int{capital[i], profits[i]})
	}
	sort.Slice(q, func(i, j int) bool {
		if q[i][0] == q[j][0] {
			return q[i][1] > q[j][1]
		} else {
			return q[i][0] < q[j][0]
		}
	})
	h2 := &MaxHeap{}
	heap.Init(h2)
	for len(q) > 0 && q[0][0] <= w {
		heap.Push(h2, q[0][1])
		q = q[1:]
	}
	ans := w
	for k > 0 && len(*h2) > 0 {
		curr := heap.Pop(h2).(int)
		w += curr
		ans = max(ans, w)
		k -= 1
		for len(q) > 0 && q[0][0] <= w {
			heap.Push(h2, q[0][1])
			q = q[1:]
		}
	}
	return ans
}
