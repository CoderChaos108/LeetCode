class Twitter {
    List<int[]> posts;
    HashMap<Integer,HashSet<Integer>> hm;
    public Twitter() {
        posts=new ArrayList<>();
        hm=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.add(new int[]{userId,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        if(!hm.containsKey(userId))
        hm.put(userId,new HashSet<>());
        HashSet<Integer> set=hm.get(userId);
        List<Integer> list=new ArrayList<>();
        for(int i=posts.size()-1;i>=0;i--){
            if(list.size()==10)
            break;
            int[] a=posts.get(i);
            int user=a[0];
            int tweet=a[1];
            if(set.contains(user)||user==userId)
            list.add(tweet);
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!hm.containsKey(followerId))
        hm.put(followerId,new HashSet<>());
        HashSet<Integer> set=hm.get(followerId);
        set.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!hm.containsKey(followerId))
        hm.put(followerId,new HashSet<>());
        HashSet<Integer> set=hm.get(followerId);
        set.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */