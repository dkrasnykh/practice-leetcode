package main

import (
	"container/heap"
)

type Heap1882 [][2]int

func (h Heap1882) Len() int { return len(h) }
func (h Heap1882) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		return h[i][1] < h[j][1]
	} else {
		return h[i][0] < h[j][0]
	}
}
func (h Heap1882) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *Heap1882) Push(x any) {
	*h = append(*h, x.([2]int))
}

func (h *Heap1882) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

type Heap18821 [][3]int

func (h Heap18821) Len() int { return len(h) }
func (h Heap18821) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		if h[i][1] == h[j][1] {
			return h[i][2] < h[j][2]
		} else {
			return h[i][1] < h[j][1]
		}
	} else {
		return h[i][0] < h[j][0]
	}
}
func (h Heap18821) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *Heap18821) Push(x any) {
	*h = append(*h, x.([3]int))
}

func (h *Heap18821) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func assignTasks(servers []int, tasks []int) []int {
	result := make([]int, len(tasks))
	free := &Heap1882{}
	heap.Init(free)
	busy := &Heap18821{}
	heap.Init(busy)
	for i := 0; i < len(servers); i++ {
		heap.Push(free, [2]int{servers[i], i})
	}
	i, time := 0, 0
	for i < len(tasks) {
		for len(*busy) > 0 {
			curr := heap.Pop(busy).([3]int)
			if curr[0] <= time {
				heap.Push(free, [2]int{curr[1], curr[2]})
			} else {
				heap.Push(busy, curr)
				break
			}
		}
		if len(*free) > 0 {
			s := heap.Pop(free).([2]int)
			result[i] = s[1]
			heap.Push(busy, [3]int{time + tasks[i], s[0], s[1]})
			i += 1
		}
		time += 1
	}
	return result
}

/*
[338,890,301,532,284,930,426,616,919,267,571,140,716,859,980,469,628,490,195,664,925,652,503,301,917,563,82,947,910,451,366,190,253,516,503,721,889,964,506,914,986,718,520,328,341,765,922,139,911,578,86,435,824,321,942,215,147,985,619,865]

[773,537,46,317,233,34,712,625,336,221,145,227,194,693,981,861,317,308,400,2,391,12,626,265,710,792,620,416,267,611,875,361,494,128,133,157,638,632,2,158,428,284,847,431,94,782,888,44,117,489,222,932,494,948,405,44,185,587,738,164,356,783,276,547,605,609,930,847,39,579,768,59,976,790,612,196,865,149,975,28,653,417,539,131,220,325,252,160,761,226,629,317,185,42,713,142,130,695,944,40,700,122,992,33,30,136,773,124,203,384,910,214,536,767,859,478,96,172,398,146,713,80,235,176,876,983,363,646,166,928,232,699,504,612,918,406,42,931,647,795,139,933,746,51,63,359,303,752,799,836,50,854,161,87,346,507,468,651,32,717,279,139,851,178,934,233,876,797,701,505,878,731,468,884,87,921,782,788,803,994,67,905,309,2,85,200,368,672,995,128,734,157,157,814,327,31,556,394,47,53,755,721,159,843]
*/
/*
func main() {
	fmt.Println(assignTasks([]int{3, 3, 2}, []int{1, 2, 3, 2, 1, 2}))
}
*/
