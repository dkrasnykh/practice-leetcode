package main

func pushDominoes(dominoes string) string {
	n := len(dominoes)
	ans := make([]byte, n)
	left, right := make([]int, n), make([]int, n)
	p := -1
	for i := 0; i < n; i++ {
		if dominoes[i] == 'R' {
			p = i
		} else if dominoes[i] == 'L' {
			p = -1
		}
		right[i] = p
	}
	p = -1
	for i := n - 1; i >= 0; i-- {
		if dominoes[i] == 'L' {
			p = i
		} else if dominoes[i] == 'R' {
			p = -1
		}
		left[i] = p
	}
	for i := 0; i < n; i++ {
		if dominoes[i] != '.' {
			ans[i] = dominoes[i]
		} else {
			if left[i] == -1 && right[i] == -1 {
				ans[i] = '.'
			} else if left[i] == -1 && right[i] != -1 {
				ans[i] = 'R'
			} else if left[i] != -1 && right[i] == -1 {
				ans[i] = 'L'
			} else {
				d := left[i] - right[i] - 1
				if i <= right[i]+d/2 {
					ans[i] = 'R'
				} else if i >= left[i]-d/2 {
					ans[i] = 'L'
				} else {
					ans[i] = '.'
				}
			}
		}
	}
	return string(ans)
}
