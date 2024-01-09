package main

func maxNumberOfBalloons(text string) int {
	balloon := map[byte]int{'b': 1, 'a': 1, 'l': 2, 'o': 2, 'n': 1}
	cnt := make(map[byte]int)
	for i := 0; i < len(text); i++ {
		cnt[text[i]] += 1
	}
	res := len(text)
	for k, _ := range balloon {
		res = min(res, cnt[k]/balloon[k])
	}
	return res
}
