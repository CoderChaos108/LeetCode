class Solution {
    long n;
    List<Long> ans=new ArrayList<>();
    public void dfs(List<Long> list,long s){
        if(s==n){
            ans=new ArrayList<>(list);
            return;
        }
            long val=0;
            if(list.size()!=0)
            val=list.get(list.size()-1);
            while(ans.size()==0){
                if(val+2>n-s)
                return;
                list.add(val+2);
                dfs(list,s+val+2);
                list.remove(list.size()-1);
                val=val+2;
            }
    }
    public List<Long> maximumEvenSplit(long finalSum) {
       n=finalSum;
       if(n%2!=0)
       return ans;
        dfs(new ArrayList<>(),0);
        return ans;
    }
}