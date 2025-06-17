class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int s=nums[0];
        for(int i:nums){
        if(i<=0)
        continue;
        if(s>i)
        s=i;
        set.add(i);
        }
        int n=1;
        while(true){
            if(!set.contains(n))
            return n;
            n++;
        }
    }
}