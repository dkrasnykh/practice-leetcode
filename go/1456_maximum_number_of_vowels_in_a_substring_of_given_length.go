package main

func maxVowels(s string, k int) int {
	vowels := map[byte]bool{'a': true, 'e': true, 'i': true, 'o': true, 'u': true}
	res, v := 0, 0
	for r := 0; r < len(s); r++ {
		if r >= k {
			l := r - k
			if vowels[s[l]] {
				v -= 1
			}
		}
		if vowels[s[r]] {
			v += 1
		}
		res = max(res, v)
	}
	return res
}
