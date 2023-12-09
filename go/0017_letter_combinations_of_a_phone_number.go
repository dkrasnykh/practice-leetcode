package main

func letterCombinations(digits string) []string {
	mapping := map[rune][]rune{'2': {'a', 'b', 'c'},
		'3': {'d', 'e', 'f'},
		'4': {'g', 'h', 'i'},
		'5': {'j', 'k', 'l'},
		'6': {'m', 'n', 'o'},
		'7': {'p', 'q', 'r', 's'},
		'8': {'t', 'u', 'v'},
		'9': {'w', 'x', 'y', 'z'}}

	result := make([]string, 0)
	curr := make([]rune, 0)
	var backtrack func(ind int)
	backtrack = func(ind int) {
		if len(curr) == len(digits) {
			result = append(result, string(curr))
			return
		}
		for i := ind; i < len(digits); i++ {
			for j := 0; j < len(mapping[rune(digits[i])]); j++ {
				curr = append(curr, mapping[rune(digits[i])][j])
				backtrack(i + 1)
				curr = curr[:len(curr)-1]
			}
		}
	}
	if len(digits) > 0 {
		backtrack(0)
	}
	return result
}
