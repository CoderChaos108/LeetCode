class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i]))
            hm.put(nums[i],new ArrayList<Integer>());
            hm.get(nums[i]).add(i);
        }
        List<Integer> ans=new ArrayList<>();
        
        for(int q:queries){
            if(hm.get(nums[q]).size()==1){
                ans.add(-1);
                continue;
            }
            List<Integer> list=hm.get(nums[q]);
            int l=0;
            int r=list.size()-1;
            int t=-1;
            while(l<=r){
                int m=(l+r)/2;
                if(list.get(m)==q){
                    t=m;
                    break;
                }
                else if(list.get(m)<q){
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
            int le=t-1;
            int re=t+1;
            if(le<0)
            le=list.size()-1;
            if(re==list.size())
            re=0;
            int li=list.get(le);
            int ri=list.get(re);
            int n=nums.length;
            int d1=Math.abs(li-q);
            d1=Math.min(d1,n-d1);
            int d2=Math.abs(ri-q);
            d2=Math.min(d2,n-d2);
            ans.add(Math.min(d1,d2));
        }
        return ans;
    }
}