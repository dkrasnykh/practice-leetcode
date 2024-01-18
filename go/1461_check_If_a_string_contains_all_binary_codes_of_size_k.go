package main

func hasAllCodes(s string, k int) bool {
	n := 1 << k
	set := map[string]struct{}{}
	for i := 0; i <= len(s)-k; i++ {
		sub := s[i : i+k]
		set[sub] = struct{}{}
	}
	return len(set) == n
}
