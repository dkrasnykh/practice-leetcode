package main

func generateParenthesis(n int) []string {
	result := make([]string, 0)
	curr := make([]rune, 0)
	var backtrack func(open, close int)
	backtrack = func(open, close int) {
		if open == n && open == close {
			tmp := string(curr)
			result = append(result, tmp)
			return
		}
		if open < n {
			curr = append(curr, '(')
			backtrack(open+1, close)
			curr = curr[:len(curr)-1]
		}
		if close < open {
			curr = append(curr, ')')
			backtrack(open, close+1)
			curr = curr[:len(curr)-1]
		}
	}
	backtrack(0, 0)
	return result
}
