package main

func maxLength(arr []string) int {
	cnt := [26]int{}
	var increase func(s string, arr *[26]int) bool
	var decrease func(s string, arr *[26]int)
	increase = func(s string, arr *[26]int) bool {
		tmp := [26]int{}
		for i := 0; i < len(s); i++ {
			ind := s[i] - 'a'
			if arr[ind] > 0 || tmp[ind] > 0 {
				return false
			}
			tmp[ind] += 1
		}
		for i := 0; i < len(s); i++ {
			ind := s[i] - 'a'
			arr[ind] += 1
		}
		return true
	}
	decrease = func(s string, arr *[26]int) {
		for i := 0; i < len(s); i++ {
			ind := s[i] - 'a'
			arr[ind] -= 1
		}
	}
	maxLen := 0
	var backtrack func(ind, length int)
	backtrack = func(ind, length int) {
		if ind == len(arr) {
			return
		}
		for i := ind; i < len(arr); i++ {
			if increase(arr[i], &cnt) {
				maxLen = max(maxLen, length+len(arr[i]))
				backtrack(i+1, length+len(arr[i]))
				decrease(arr[i], &cnt)
			}
		}
	}
	backtrack(0, 0)
	return maxLen
}
