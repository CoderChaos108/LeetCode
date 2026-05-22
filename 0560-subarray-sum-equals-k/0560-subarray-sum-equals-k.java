class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        int s=0;
        for(int i=0;i<nums.length;i++){
            prefix[i]=s;
            s=s+nums[i];
        }
        
        prefix[nums.length]=s;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<prefix.length;i++){
            int p=prefix[i];
            if(!hm.containsKey(prefix[i]))
            hm.put(prefix[i],new ArrayList<>());
            List<Integer> list=hm.get(p);
            list.add(i);
        }
        int ans=0;
        for(int i=0;i<prefix.length;i++){
            int p=prefix[i];
            int o=p+k;
            if(!hm.containsKey(o))
            continue;
            List<Integer> list=hm.get(o);
            int l=0;
            int res=list.size();
            int r=list.size()-1;
            while(l<=r){
                int m=(l+r)/2;
                if(list.get(m)>i){
                    res=m;
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
            ans=ans+(list.size()-res);
        }

        return ans;
    }
}