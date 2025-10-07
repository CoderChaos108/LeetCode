class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        int[] ans=new int[rains.length];
        for(int i=0;i<rains.length;i++){
            int lake=rains[i];
            if(lake!=0){
                ans[i]=-1;
                if(hm.containsKey(lake)){
                    if(list.size()==0||list.get(list.size()-1)<hm.get(lake))
                    return new int[0];
                    int idx=list.get(list.size()-1);
                    ans[idx]=lake;
                    list.remove(list.size()-1);
                }
                else
                hm.put(lake,i);
            }
            else{
                list.add(i);
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==0)
            ans[i]=1;
        }
        return ans;
    }
}