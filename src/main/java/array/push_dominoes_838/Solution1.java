package array.push_dominoes_838;

import java.util.ArrayDeque;

class Pair {
    int ind;
    char d;

    public Pair(int ind, char d) {
        this.ind = ind;
        this.d = d;
    }
}

public class Solution1 {
    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        ArrayDeque<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < dom.length; ++i) {
            if (dom[i] != '.') {
                q.addLast(new Pair(i, dom[i]));
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.pollFirst();
            int i = p.ind, d = p.d;
            if (d == 'L' && i > 0 && dom[i - 1] == '.') {
                q.addLast(new Pair(i - 1, 'L'));
                dom[i - 1] = 'L';
            } else if (d == 'R'){
                if(i + 1 < dom.length && dom[i + 1] == '.'){
                    if(i + 2 < dom.length && dom[i + 2] == 'L'){
                        q.pollFirst();
                    } else {
                        q.addLast(new Pair(i + 1, 'R'));
                        dom[i + 1] = 'R';
                    }
                }
            }
        }
        return new String(dom);
    }

    public static void main(String[] args) {

    }
}
