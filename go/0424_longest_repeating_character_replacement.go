package main

func characterReplacement(s string, k int) int {
	segm := [26][][2]int{}
	l := 0
	for i := 1; i < len(s); i++ {
		if s[i] != s[i-1] {
			segm[s[i-1]-'A'] = append(segm[s[i-1]-'A'], [2]int{l, i - 1})
			l = i
		}
	}
	segm[s[len(s)-1]-'A'] = append(segm[s[len(s)-1]-'A'], [2]int{l, len(s) - 1})
	result := 0
	for i := 0; i < 26; i++ {
		total, tmp, left := 0, k, 0
		for j := 0; j < len(segm[i]); j++ {
			start, end := segm[i][j][0], segm[i][j][1]
			total += (end - start + 1)
			if j == len(segm[i])-1 {
				result = max(result, min(total+tmp, len(s)))
				continue
			}
			d := segm[i][j+1][0] - segm[i][j][1] - 1
			if d > tmp {
				result = max(result, min(total+tmp, len(s)))
				for d > tmp && left < j {
					start, end = segm[i][left][0], segm[i][left][1]
					total -= (end - start + 1)
					next := segm[i][left+1][0] - segm[i][left][1] - 1
					tmp += next
					total -= next
					left += 1
				}
				if d > tmp {
					result = max(result, min(total+tmp, len(s)))
					total = 0
					tmp = k
					left = j + 1
					continue
				}
			}
			tmp -= d
			total += d
		}
	}
	return result
}
