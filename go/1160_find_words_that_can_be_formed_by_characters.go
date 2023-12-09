package main

func countCharacters(words []string, chars string) int {
	cnt := [26]int{}
	for i := 0; i < len(chars); i++ {
		cnt[chars[i]-'a'] += 1
	}
	ans := 0
	for _, w := range words {
		tmp := cnt
		isGood := true
		for i := 0; i < len(w); i++ {
			tmp[w[i]-'a'] -= 1
			if tmp[w[i]-'a'] < 0 {
				isGood = false
				break
			}
		}
		if isGood {
			ans += len(w)
		}
	}
	return ans
}
