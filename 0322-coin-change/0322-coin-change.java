class Solution {
    public int coinChange(int[] coins, int amount) {
       Queue<Integer> q=new LinkedList<>();
       Arrays.sort(coins);
       int steps=0;
       q.add(0);
       HashSet<Integer> seen=new HashSet<>();
       while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            int s=q.poll();
            if(!seen.add(s))
            continue;
            if(s==amount)
            return steps;
            for(int val:coins){
                if(s+val>amount)
                break;
                q.add(s+val);
            }
        }
        steps++;
       }     
       return -1;
    }
}