package main

import (
	"sort"
)

func leastBricks(wall [][]int) int {
	event := make([][2]int, 0)
	length := 0
	for i := 0; i < len(wall); i++ {
		start := 0
		for j := 0; j < len(wall[i]); j++ {
			a := start
			b := start + wall[i][j]
			event = append(event, [...]int{a, 1})
			event = append(event, [...]int{b, -1})
			start = b
		}
		length = start
	}
	sort.Slice(event, func(i, j int) bool {
		if event[i][0] == event[j][0] {
			return event[i][1] < event[j][1]
		}
		return event[i][0] < event[j][0]
	})
	open, ans := 0, len(wall)
	for _, e := range event {
		x := e[0]
		state := e[1]
		if state == 1 {
			open += 1
		} else {
			open -= 1
			if x != length {
				ans = min(ans, open)
			}
		}
	}
	return ans
}
