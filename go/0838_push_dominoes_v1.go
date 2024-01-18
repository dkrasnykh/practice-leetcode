package main

// https://www.youtube.com/watch?v=evUFsOb_iLY
func pushDominoes1(dominoes string) string {
	dom, n := []byte(dominoes), len(dominoes)
	q := make([][2]int, 0)
	for i := 0; i < n; i++ {
		if dom[i] != '.' {
			q = append(q, [2]int{i, int(dom[i])})
		}
	}
	for len(q) > 0 {
		c := byte(q[0][1])
		ind := q[0][0]
		q = q[1:]
		if c == 'L' && ind-1 >= 0 && dom[ind-1] == '.' {
			dom[ind-1] = 'L'
			q = append(q, [2]int{ind - 1, int('L')})
		} else if c == 'R' && ind+1 < n && dom[ind+1] == '.' {
			if len(q) > 0 && byte(q[0][1]) == 'L' && ind+1 == q[0][0]-1 {
				q = q[1:]
			} else {
				dom[ind+1] = 'R'
				q = append(q, [2]int{ind + 1, int('R')})
			}
		}
	}
	return string(dom)
}
