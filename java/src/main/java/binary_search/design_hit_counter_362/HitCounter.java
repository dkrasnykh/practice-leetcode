package binary_search.design_hit_counter_362;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {
    private List<Integer> hits;
    public HitCounter(){
        hits = new ArrayList<>();
    }

    public void hit(int timestamp){
        hits.add(timestamp);
    }

    public int getHits(int timestamp){
        if (hits.isEmpty()) return 0;
        int l = 0, r = hits.size() - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(hits.get(m) <= timestamp - 300){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return hits.size() - l;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        //hit at timestamp 1
        counter.hit(1);
        //hit at timestamp 2.
        counter.hit(2);
        //hit a timestamp 3
        counter.hit(3);
        //get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));
        //hit at timestamp 300
        counter.hit(300);
        //get hits at timetsamp 300, should return 4
        System.out.println(counter.getHits(300));
        //git hits at timetsamp 301, should return 3.
        System.out.println(counter.getHits(301));

        System.out.println(counter.getHits(900));
    }
}
