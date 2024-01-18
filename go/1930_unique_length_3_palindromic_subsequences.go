package main

func countPalindromicSubsequence(s string) int {
	cnt := [26][2]int{}
	for i := 0; i < 26; i++ {
		cnt[i][0], cnt[i][1] = -1, -1
	}
	for i := 0; i < len(s); i++ {
		if cnt[s[i]-'a'][0] == -1 {
			cnt[s[i]-'a'][0] = i
		} else {
			cnt[s[i]-'a'][1] = i
		}
	}
	ans := 0
	for i := 0; i < 26; i++ {
		if cnt[i][0] != -1 && cnt[i][1] != -1 && cnt[i][1]-cnt[i][0] > 1 {
			m := map[byte]struct{}{}
			for j := cnt[i][0] + 1; j < cnt[i][1]; j++ {
				m[s[j]] = struct{}{}
			}
			ans += len(m)
		}
	}
	return ans
}
