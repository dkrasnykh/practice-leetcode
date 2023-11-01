package stack.simplify_path_71;

import java.util.ArrayDeque;

public class Solution {
    public String simplifyPath(String path) {
        path = path.replaceAll("[\\/]{2,}", "/");
        String[] parts = path.split("/");
        ArrayDeque<String> canonical = new ArrayDeque<>();
        for(String p : parts){
            if(p.trim().equals("..") && !canonical.isEmpty()){
                canonical.pollLast();
            } else if (!p.trim().isEmpty() && !p.trim().equals(".") && !p.trim().equals("..")){
                canonical.addLast(p.trim());
            }
        }
        return "/".concat(String.join("/", canonical));
    }

    public static void main(String[] args) {
        //System.out.println("Твой      текст           тут".replaceAll("[\\s]{2,}", " "));
        //System.out.println("Твой//  ///текст////   ////тут".replaceAll("[\\/]{2,}", "/"));
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/"));
    }
}
