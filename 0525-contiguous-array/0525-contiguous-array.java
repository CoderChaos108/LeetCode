class Solution {
    public int findMaxLength(int[] nums) {
        int[] pre=new int[nums.length];
        int s=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            s=s+1;
            else
            s--;
            pre[i]=s;
            hm.put(s,i);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int l=i;
            int p=pre[l];
            int r=-1;
            if(hm.containsKey(p))
            r=hm.get(p);
            ans=Math.max(ans,r-l);
        }
        if(hm.containsKey(0)){
            int r=hm.get(0);
            ans=Math.max(ans,r+1);
        }
        return ans;
    }
}