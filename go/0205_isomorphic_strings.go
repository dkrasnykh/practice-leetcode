package main

func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	st := make(map[byte]byte)
	ts := make(map[byte]byte)
	for i := 0; i < len(s); i++ {
		si, oks := st[s[i]]
		ti, okt := ts[t[i]]
		if oks && !okt || !oks && okt || oks && okt && (si != t[i] || ti != s[i]) {
			return false
		}
		st[s[i]] = t[i]
		ts[t[i]] = s[i]
	}
	return true
}
