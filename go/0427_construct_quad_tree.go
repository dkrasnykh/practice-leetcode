package main

type Node1 struct {
	Val         bool
	IsLeaf      bool
	TopLeft     *Node1
	TopRight    *Node1
	BottomLeft  *Node1
	BottomRight *Node1
}

func construct(grid [][]int) *Node1 {
	isLeaf := func(topLeft_row, topLeft_col, bottomRight_row, bottomRight_col int) bool {
		for i := topLeft_row; i <= bottomRight_row; i++ {
			for j := topLeft_col; j <= bottomRight_col; j++ {
				if grid[topLeft_row][topLeft_col] != grid[i][j] {
					return false
				}
			}
		}
		return true
	}

	val := func(num int) bool {
		if num == 0 {
			return false
		}
		return true
	}

	var dfs func(topLeft_row, topLeft_col, bottomRight_row, bottomRight_col int) *Node1
	dfs = func(topLeft_row, topLeft_col, bottomRight_row, bottomRight_col int) *Node1 {
		if isLeaf(topLeft_row, topLeft_col, bottomRight_row, bottomRight_col) {
			return &Node1{
				Val:    val(grid[topLeft_row][topLeft_col]),
				IsLeaf: true,
			}
		}
		board := (bottomRight_row - topLeft_row + 1) / 2
		root := &Node1{
			Val:         true,
			IsLeaf:      false,
			TopLeft:     dfs(topLeft_row, topLeft_col, topLeft_row+board-1, topLeft_col+board-1),
			TopRight:    dfs(topLeft_row, topLeft_col+board, topLeft_row+board-1, bottomRight_col),
			BottomLeft:  dfs(topLeft_row+board, topLeft_col, bottomRight_row, topLeft_col+board-1),
			BottomRight: dfs(topLeft_row+board, topLeft_col+board, bottomRight_row, bottomRight_col),
		}
		return root
	}
	return dfs(0, 0, len(grid[0])-1, len(grid[0])-1)
}

/*
func main() {
	grid := [][]int{{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}}
	root := construct(grid)
	_ = root
}
*/
