package main

func minOperations(s string) int {
	op := func(even, odd byte) int {
		res := 0
		for i := 0; i < len(s); i++ {
			if i%2 == 0 && s[i] != even {
				res += 1
			}
			if i%2 == 1 && s[i] != odd {
				res += 1
			}
		}
		return res
	}
	return min(op(byte('1'), byte('0')),
		op(byte('0'), byte('1')))
}
