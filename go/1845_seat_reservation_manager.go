package main

import "container/heap"

type SeatManager struct {
	h *IntHeap
}

func Constructor2(n int) SeatManager {
	hh := &IntHeap{}
	heap.Init(hh)
	for i := 1; i <= n; i++ {
		heap.Push(hh, i)
	}
	return SeatManager{h: hh}
}

func (this *SeatManager) Reserve() int {
	seatNumber := heap.Pop(this.h).(int)
	return seatNumber
}

func (this *SeatManager) Unreserve(seatNumber int) {
	heap.Push(this.h, seatNumber)
}
