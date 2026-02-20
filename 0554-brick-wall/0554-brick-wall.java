class Solution {
    public int leastBricks(List<List<Integer>> wall) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       int ans=0;
       for(List<Integer> list:wall){
            int s=0;
            for(int i=0;i<list.size()-1;i++){
                s=s+list.get(i);
                hm.put(s,hm.getOrDefault(s,0)+1);
                ans=Math.max(ans,hm.get(s));
            }
       }
       return wall.size()-ans; 
    }
}