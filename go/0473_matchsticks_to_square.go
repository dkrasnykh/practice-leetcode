package main

func makesquare(matchsticks []int) bool {
	total := 0
	for i := 0; i < len(matchsticks); i++ {
		total += matchsticks[i]
	}
	if total%4 != 0 {
		return false
	}
	size := total / 4
	sides := [4]int{}
	used := make([]bool, len(matchsticks))

	var backtrack func(ind, indj int) bool

	backtrack = func(ind, indj int) bool {
		if sides[0] == size && sides[1] == size && sides[2] == size && sides[3] == size {
			return true
		}
		if sides[ind] > size {
			return false
		}
		ans := false
		for j := indj; j < len(matchsticks); j++ {
			if used[j] {
				continue
			}
			if sides[ind]+matchsticks[j] <= size {
				used[j] = true
				sides[ind] += matchsticks[j]
				if sides[ind] == size {
					ans = ans || backtrack(ind+1, 0)
				} else {
					ans = ans || backtrack(ind, j+1)
				}
				used[j] = false
				sides[ind] -= matchsticks[j]
			}
		}
		return ans
	}

	return backtrack(0, 0)
}
