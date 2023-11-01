package priority_queue.design_twitter_355;

import java.util.*;

public class Twitter {
    private Map<Integer, Set<Integer>> followers;
    private PriorityQueue<int[]> q;
    private int time;

    public Twitter() {
        this.followers = new HashMap<>();
        this.q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : b[0] - a[0]);
    }

    private void initUser(int userId) {
        if (!followers.containsKey(userId)) {
            followers.put(userId, new HashSet<>(List.of(userId)));
        }
    }

    public void postTweet(int userId, int tweetId) {
        initUser(userId);
        this.q.add(new int[]{this.time, userId, tweetId});
        this.time += 1;
    }

    public List<Integer> getNewsFeed(int userId) {
        initUser(userId);
        List<Integer> result = new ArrayList<>();
        List<int[]> tmp = new ArrayList<>();
        while (result.size() < 10 && !this.q.isEmpty()) {
            //time, userId, tweetId
            int[] e = this.q.poll();
            if (followers.get(userId).contains(e[1])) {
                result.add(e[2]);
            }
            tmp.add(e);
        }
        this.q.addAll(tmp);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        initUser(followerId);
        this.followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        initUser(followerId);
        if (this.followers.containsKey(followerId)) {
            this.followers.get(followerId).remove(followeeId);
        }
    }
}
