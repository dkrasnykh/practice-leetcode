package main

func minimumFuelCost(roads [][]int, seats int) int64 {
	adj := make(map[int]map[int]struct{})
	p := make(map[int]int)
	for i := 0; i < len(roads); i++ {
		ai := roads[i][0]
		bi := roads[i][1]
		if adj[ai] == nil {
			adj[ai] = make(map[int]struct{})
		}
		if adj[bi] == nil {
			adj[bi] = make(map[int]struct{})
		}
		adj[ai][bi] = struct{}{}
		adj[bi][ai] = struct{}{}
		p[ai] = 1
		p[bi] = 1
	}
	q := make([]int, 0)
	for k, v := range adj {
		if len(v) == 1 && k != 0 {
			q = append(q, k)
			p[k] = 1
		}
	}
	cnt := int64(0)
	for len(q) > 0 {
		size := len(q)
		tmp := make(map[int]struct{})
		for size > 0 {
			curr := q[0]
			q = q[1:]
			if p[curr]%seats != 0 {
				cnt += int64(p[curr]/seats + 1)
			} else {
				cnt += int64(p[curr] / seats)
			}
			var next int
			for k := range adj[curr] {
				if p[k] != -1 {
					next = k
					break
				}
			}
			p[next] += p[curr]
			p[curr] = -1
			delete(adj[next], curr)
			if next != 0 {
				tmp[next] = struct{}{}
			}
			size -= 1
		}
		for k := range tmp {
			if len(adj[k]) == 1 {
				q = append(q, k)
			}
		}
	}
	return cnt
}

/*
func main() {
	//[[0,1],[0,2],[0,3]]
	//seats = 5
	//fmt.Println(minimumFuelCost([][]int{{0, 1}, {0, 2}, {0, 3}}, 5))
	//[[0,1],[0,2],[2,3],[2,4]]
	//fmt.Println(minimumFuelCost([][]int{{0, 1}, {0, 2}, {2, 3}, {2, 4}}, 5))
	//[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]
	//fmt.Println(minimumFuelCost([][]int{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2))
	//[[0,1],[1,2]]  seats = 3
	//fmt.Println(minimumFuelCost([][]int{{0, 1}, {1, 2}}, 3))
	//[[1,0],[1,2],[3,2],[4,1],[0,5],[6,5],[5,7]]  seats = 7
	fmt.Println(minimumFuelCost([][]int{{1, 0}, {1, 2}, {3, 2}, {4, 1}, {0, 5}, {6, 5}, {5, 7}}, 7))
}
*/
