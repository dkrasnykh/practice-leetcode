package main

func minSwaps(s string) int {
	closed, maxClose := 0, 0
	for _, c := range s {
		if c == '[' {
			closed -= 1
		} else {
			closed += 1
		}
		maxClose = max(closed, maxClose)
	}
	return (maxClose + 1) / 2
}
