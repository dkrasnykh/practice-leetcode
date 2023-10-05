package arrays_hashing.push_dominoes_838;

import java.util.ArrayDeque;

public class Solution {
    public String pushDominoes(String dominoes) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dominoes.length(); ++i){
            if(dominoes.charAt(i)=='.'){
                stack.addLast('.');
            } else if (dominoes.charAt(i)=='R'){
                if(!stack.isEmpty()){
                    Character appended = stack.getFirst();
                    while(!stack.isEmpty()){
                        sb.append(appended);
                        stack.pollFirst();
                    }
                }
                stack.addLast('R');
            } else if (dominoes.charAt(i)=='L'){
                stack.addLast('L');
                if(stack.getFirst() == 'R'){
                    int size = stack.size();
                    for(int j = 0; j < size/2; ++j){
                        sb.append('R');
                        stack.pollFirst();
                    }
                    if(size %2 == 1){
                        sb.append('.');
                        stack.pollFirst();
                    }
                    for(int j = 0; j < size/2; ++j){
                        sb.append('L');
                        stack.pollFirst();
                    }
                } else {
                    while(!stack.isEmpty()){
                        stack.pollFirst();
                        sb.append('L');
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            Character appended = stack.getFirst();
            while(!stack.isEmpty()){
                sb.append(appended);
                stack.pollFirst();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
