class Solution {
    HashMap<List<Integer>,Integer> hm=new HashMap<>();
    int n;
    int s;
    public int find(int i,int sum,int[] a,int target){
        List<Integer> list=Arrays.asList(i,sum);
        if(i>=n){
            if(sum==target)
            return 1;
            return 0;
        }
        int res=0;
        if(hm.containsKey(list))
        return hm.get(list);
        res=find(i+1,sum,a,target)+find(i+1,sum-2*a[i],a,target);
        hm.put(list,res);
        return res;
    }
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        s=0;
        for(int i:nums)
        s=s+i;
        return find(0,s,nums,target);
    }
}