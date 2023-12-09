package main

import (
	"container/heap"
)

func leastInterval(tasks []byte, n int) int {
	m := make(map[byte]int)
	for i := 0; i < len(tasks); i++ {
		m[tasks[i]] += 1
	}
	h := &MaxHeap{}
	heap.Init(h)
	for _, v := range m {
		heap.Push(h, v)
	}
	time := 0
	q := make([][2]int, 0)
	for len(*h) > 0 || len(q) != 0 {
		time += 1
		if len(*h) > 0 {
			cnt := heap.Pop(h).(int) - 1
			if cnt > 0 {
				q = append(q, [...]int{cnt, time + n})
			}
		}
		if len(q) > 0 && q[0][1] == time {
			e := q[0][0]
			q = q[1:]
			heap.Push(h, e)
		}
	}
	return time
}
