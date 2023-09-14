package graphs.reconstruct_itinerary_332;

import java.util.*;

//https://www.youtube.com/watch?v=ZyB_gQ8vqGA
public class Solution {
    private Map<String, List<String>> adj = new HashMap<>();
    private  int ticketsSize;
    private boolean dfs(List<String> path, String src){
        if(path.size() == ticketsSize + 1){
            return true;
        }
        if(!adj.containsKey(src)){
            return false;
        }
        List<String> temp = new ArrayList<>(adj.get(src));
        for(int i = 0; i < temp.size(); ++i){
            String v = temp.get(i);
            adj.get(src).remove(i);
            path.add(v);
            if(dfs(path, v)) return true;
            adj.get(src).add(i, v);
            path.remove(path.size() - 1);
        }
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        ticketsSize = tickets.size();
        for (List<String> ticket : tickets) {
            if (adj.containsKey(ticket.get(0))) {
                adj.get(ticket.get(0)).add(ticket.get(1));
            } else {
                adj.put(ticket.get(0), new ArrayList<>(List.of(ticket.get(1))));
            }
        }
        for(Map.Entry<String, List<String>> e : adj.entrySet()){
            Collections.sort(e.getValue());
        }
        List<String> path = new ArrayList<>(List.of("JFK"));
        dfs(path, "JFK");
        return path;
    }

    public static void main(String[] args) {
        //tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        Solution s = new Solution();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(List.of("JFK","SFO")));
        tickets.add(new ArrayList<>(List.of("JFK","ATL")));
        tickets.add(new ArrayList<>(List.of("SFO","ATL")));
        tickets.add(new ArrayList<>(List.of("ATL","JFK")));
        tickets.add(new ArrayList<>(List.of("ATL","SFO")));
        System.out.println(s.findItinerary(tickets));
    }
}
