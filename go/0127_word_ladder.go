package main

func ladderLength(beginWord string, endWord string, wordList []string) int {
	adj := make(map[string][]string, 0)
	adj[beginWord] = make([]string, 0)
	for i := 0; i < len(wordList); i++ {
		adj[wordList[i]] = make([]string, 0)
	}

	if _, ok := adj[endWord]; !ok {
		return 0
	}

	match := func(s1 string, s2 string) int {
		rs1 := []rune(s1)
		rs2 := []rune(s2)
		cnt := 0
		for i := 0; i < len(rs1); i++ {
			if rs1[i] != rs2[i] {
				cnt += 1
			}
		}
		return cnt
	}
	for k := range adj {
		for i := 0; i < len(wordList); i++ {
			if match(k, wordList[i]) == 1 {
				adj[k] = append(adj[k], wordList[i])
			}
		}
	}

	d := make(map[string]int, 0)
	for i := 0; i < len(wordList); i++ {
		d[wordList[i]] = -1
	}
	d[beginWord] = 0

	q := []string{beginWord}

	for len(q) > 0 {
		v := q[0]
		q = q[1:]
		for _, u := range adj[v] {
			if d[u] == -1 || d[u] > d[v]+1 {
				d[u] = d[v] + 1
				q = append(q, u)
			}
		}
	}

	if d[endWord] == -1 {
		return 0
	} else {
		return d[endWord] + 1
	}
}
