class Solution {

    class Pair {
        long val;
        char node;
        Pair(long val,char node){
            this.val=val;
            this.node=node;
        }
    }

    public long minimumCost(String source,String target,char[] original,char[] changed,int[] cost){
        long[][] map=new long[26][26];
        List<Pair>[] graph=new ArrayList[26];
        for(int i=0;i<26;i++)
            graph[i]=new ArrayList<>();

        for(int i=0;i<original.length;i++){
            graph[original[i]-'a'].add(new Pair((long)cost[i],changed[i]));
        }

        long ans=0;
        for(int i=0;i<source.length();i++){
            boolean[] seen=new boolean[26];
            char start=source.charAt(i);
            char end=target.charAt(i);
            if(map[start-'a'][end-'a']!=0){
                ans=ans+map[start-'a'][end-'a'];
                continue;
            }
            PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.val,b.val));
            pq.add(new Pair(0L,start));
            boolean found=false;
            while(!pq.isEmpty()){
                Pair a=pq.poll();
                char node=a.node;
                long currentCost=a.val;
                if(seen[node-'a'])
                continue;
                seen[node-'a']=true;
                if(node==end){
                    ans=ans+currentCost;
                    found=true;
                    map[start-'a'][end-'a']=currentCost;
                    break;
                }
                for(Pair p:graph[node-'a']){
                    pq.add(new Pair(p.val+currentCost,p.node));
                }
            }
            if(!found)
            return -1; 
        }
        return ans;
    }
}
