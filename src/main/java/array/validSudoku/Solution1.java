package array.validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return a == pair.a && b == pair.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

public class Solution1 {
    public Map<Integer, Set<Character>> init(){
        Map<Integer, Set<Character>> collection = new HashMap<>();
        for(int i = 0; i < 9; ++i){
            collection.put(i, new HashSet<>());
        }
        return collection;
    }
    public Map<Pair, Set<Character>> init1(){
        Map<Pair, Set<Character>> squares = new HashMap<>();
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                squares.put(new Pair(i, j), new HashSet<>());
            }
        }
        return squares;
    }
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = init();
        Map<Integer, Set<Character>> columns = init();
        Map<Pair, Set<Character>> squares = init1();
        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] == '.') {
                    continue;
                }
                if(rows.get(r).contains(board[r][c]) ||
                        columns.get(c).contains(board[r][c]) ||
                        squares.get(new Pair(r/3, c/3)).contains(board[r][c])){
                    return false;
                }
                rows.get(r).add(board[r][c]);
                columns.get(c).add(board[r][c]);
                squares.get(new Pair(r/3, c/3)).add(board[r][c]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
