package stack.simplify_path_71;

import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class Solution1 {
    public String simplifyPath(String path) {
        ArrayDeque<String> deq = new ArrayDeque<>();
        int length = 0;
        path = path.concat("/");
        for(int i = 0; i < path.length(); ++i){
            if(path.charAt(i) == '/' && length > 0){
                String sub = path.substring(i - length, i);
                if(sub.equals("..") && !deq.isEmpty()){
                    deq.pollLast();
                } else if (!sub.equals(".") && !sub.equals("..")){
                    deq.addLast(sub);
                }
                length = 0;
            } else if (path.charAt(i) != '/') {
                length += 1;
            }
        }
        return "/".concat(deq.stream().collect(Collectors.joining("/")));
    }
}
