class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length-1;
        for(int i:nums)
        hm.put(i,hm.getOrDefault(i,0)+1);
        for(int i=1;i<n;i++){
            int f=hm.getOrDefault(i,0);
            if(f!=1)
            return false;
        }
        int f=hm.getOrDefault(n,0);
        return f==2;
    }
}