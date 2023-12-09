package main

func isSubsequence(s string, t string) bool {
	j := 0
	for i := 0; i < len(t); i++ {
		if j < len(s) && s[j] == t[i] {
			j += 1
		}
	}
	return j == len(s)
}
