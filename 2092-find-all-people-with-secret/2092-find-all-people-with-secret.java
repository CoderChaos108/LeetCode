class Solution {
    List<int[]>[] graph;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
        graph[i]=new ArrayList<>();
        }
        graph[0].add(new int[]{firstPerson,0});
        for(int[] a:meetings){
            graph[a[0]].add(new int[]{a[1],a[2]});
            graph[a[1]].add(new int[]{a[0],a[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        List<Integer> ans=new ArrayList<>();
        int[] t=new int[n];
        for(int i=0;i<n;i++)
        t[i]=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            int person=a[0];
            int time=a[1];
            if(time>t[person])
            continue;
            for(int[] neighs:graph[person]){
                int next=neighs[0];
                int met=neighs[1];
                if(met>=time&&met<t[next]){
                    t[next]=met;
                    pq.add(neighs);
                }
            }
        }
        ans.add(0);
        for(int i=1;i<n;i++){
            if(t[i]!=Integer.MAX_VALUE)
            ans.add(i);
        }
        return ans;
    }
}