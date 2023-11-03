package graphs.course_schedule_208;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<Integer>[] adjList;
    int[] used;
    private boolean dfs(int v){
        used[v] = 1;
        for(Integer u : adjList[v]){
            if (used[u] == 0) dfs(u);
            if (used[u] == 1) return true;
        }
        used[v] = 2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new List[numCourses];
        for(int i = 0; i < numCourses; ++i){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; ++i){
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean result = false;
        for(int i = 0; i < numCourses; ++i){
            used = new int[numCourses];
            if(used[i] == 0){
                result |= dfs(i);
            }
        }
        return !result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(s.canFinish(3, new int[][]{{1,0},{2,0},{0,2}}));

    }
}
