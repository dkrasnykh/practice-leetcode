package main

import "sort"

func carPooling(trips [][]int, capacity int) bool {
	events := make([][3]int, 0, 2*len(trips))
	for i := 0; i < len(trips); i++ {
		numPass := trips[i][0]
		s := trips[i][1]
		f := trips[i][2]
		events = append(events, [3]int{s, 1, numPass})
		events = append(events, [3]int{f, -1, numPass})
	}
	sort.Slice(events, func(i, j int) bool {
		if events[i][0] == events[j][0] {
			if events[i][1] == events[j][1] {
				return events[i][2] < events[j][2]
			} else {
				return events[i][1] < events[j][1]
			}
		} else {
			return events[i][0] < events[j][0]
		}
	})

	totalPass := 0
	for i := 0; i < len(events); i++ {
		//x := events[i][0]
		state := events[i][1]
		numPass := events[i][2]
		if state == 1 {
			totalPass += numPass
			if totalPass > capacity {
				return false
			}
		} else {
			totalPass -= numPass
		}
	}
	return true
}
