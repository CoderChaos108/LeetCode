class Solution {
    public int leastBricks(List<List<Integer>> wall) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       int ans=0;
       int sum=0;
       for(int i:wall.get(0))
       sum=sum+i;
       for(List<Integer> list:wall){
            int s=0;
            for(int i:list){
                s=s+i;
                if(s==sum)
                break;
                hm.put(s,hm.getOrDefault(s,0)+1);
                ans=Math.max(ans,hm.get(s));
            }
       }
       int s=0;
       for(int i:wall.get(0))
       s=s+i;
       return wall.size()-ans; 
    }
}