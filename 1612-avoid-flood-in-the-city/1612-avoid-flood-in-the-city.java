class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        TreeSet<Integer> list=new TreeSet<>();
        int[] ans=new int[rains.length];
        for(int i=0;i<rains.length;i++){
            int lake=rains[i];
            if(lake!=0){
                ans[i]=-1;
                if(hm.containsKey(lake)){
                    int idx=-1;
                    int last=hm.get(lake);
                    if(list.size()==0||list.last()<last)
                    return new int[0];
                    for(int itr:list){
                        if(itr>last){
                            idx=itr;
                            break;
                        }
                    }
                    ans[idx]=lake;
                    list.remove(idx);
                }
                hm.put(lake,i);
            }
            else{
                list.add(i);
                ans[i]=1;
            }
        }
        return ans;
    }
}