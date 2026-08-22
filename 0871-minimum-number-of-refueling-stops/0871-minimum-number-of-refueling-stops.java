class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int fuel=startFuel;
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int[] a:stations){
            if(fuel>=target)
            return ans;
            int dis=a[0];
            if(dis<=fuel)
            pq.add(a[1]);
            else{
                while(fuel<dis){
                    if(pq.isEmpty())
                    return -1;
                    fuel=fuel+pq.poll();
                    ans++;
                }
                pq.add(a[1]);
            }
        }
        while(!pq.isEmpty()){
            if(fuel>=target)
            return ans;
            fuel=fuel+pq.poll();
            ans++;
        }
        if(fuel>=target)
        return ans;
        return -1;
    }
}