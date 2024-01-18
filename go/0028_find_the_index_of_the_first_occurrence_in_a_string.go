package main

func strStr(haystack string, needle string) int {
	/*
		//another solution:
			if len(haystack) < len(needle) {
				return -1
			}
			for i := len(needle) - 1; i < len(haystack); i++ {
				l := i - len(needle) + 1
				if haystack[l:i+1] == needle {
					return l
				}
			}
			return -1
	*/

	lh := len(haystack)
	ln := len(needle)
	for i := 0; i <= (lh - ln); i++ {
		ct := 0
		for j := 0; j < ln; j++ {
			if haystack[i+j] != needle[j] {
				break
			}
			ct += 1
		}
		if ct == ln {
			return i
		}
	}
	return -1
}
