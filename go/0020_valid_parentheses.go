package main

func isValid1(s string) bool {
	closeToOpen := map[byte]byte{')': '(', '}': '{', ']': '['}
	stack := make([]byte, 0)
	for i := 0; i < len(s); i++ {
		_, ok := closeToOpen[s[i]]
		if len(stack) == 0 && ok || ok && stack[len(stack)-1] != closeToOpen[s[i]] {
			return false
		}
		if ok {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}
