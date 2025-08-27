class Solution {
    List<Integer>[] graph;
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n=friends.length;
       graph=new ArrayList[n];
       for(int i=0;i<n;i++){
        graph[i]=new ArrayList<>();
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<friends[i].length;j++){
            graph[i].add(friends[i][j]);
        }
       }
       boolean[] seen=new boolean[n];
       List<Integer> friendList=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
        q.add(id);
        int l=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int node=q.poll();
                if(seen[node])
                continue;
                seen[node]=true;
                if(l==level)
                friendList.add(node);
                for(int neigh:graph[node]){
                    q.add(neigh);
                }
            }
            l++;
        }
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i:friendList){
            for(String s:watchedVideos.get(i))
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            int f=hm.get(a)-hm.get(b);
            if(f!=0)
            return f;
            else{
                return a.compareTo(b);
            }
        });
        for(String s:hm.keySet()){
            pq.add(s);
        }
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty())
        ans.add(pq.poll());
        return ans;
    }  
}