package main

import "sort"

func successfulPairs(spells []int, potions []int, success int64) []int {
	sort.Ints(potions)
	search := func(spell int) int {
		l, r := 0, len(potions)-1
		for l <= r {
			m := l + (r-l)/2
			if int64(potions[m])*int64(spell) < success {
				l = m + 1
			} else {
				r = m - 1
			}
		}
		return l
	}
	result := make([]int, len(spells))
	for i := 0; i < len(spells); i++ {
		ind := search(spells[i])
		result[i] = len(potions) - ind
	}
	return result
}
