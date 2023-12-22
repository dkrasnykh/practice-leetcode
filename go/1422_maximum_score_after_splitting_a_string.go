package main

func maxScore1(s string) int {
	ones := 0
	for i := 0; i < len(s); i++ {
		if s[i] == 49 {
			ones += 1
		}
	}
	res := -1
	zeros := 0
	for i := 0; i < len(s)-1; i++ {
		if s[i] == 48 {
			zeros += 1
		} else {
			ones -= 1
		}
		res = max(res, zeros+ones)
	}
	return res
}
