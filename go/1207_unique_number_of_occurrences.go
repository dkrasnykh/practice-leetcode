package main

func uniqueOccurrences(arr []int) bool {
	cnt := map[int]int{}
	for i := 0; i < len(arr); i++ {
		cnt[arr[i]] += 1
	}
	unique := map[int]struct{}{}
	for k, _ := range cnt {
		unique[cnt[k]] = struct{}{}
	}
	return (len(cnt) == len(unique))
}
