class Solution {
    boolean sorted(int[] nums,boolean[] seen){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<seen.length;i++){
            if(!seen[i])
            list.add(nums[i]);
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1))
            return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        boolean[] seen=new boolean[nums.length];
        int ans=0;
        while(!sorted(nums,seen)){
            int l=0;
            int m=0;
            int minS=Integer.MAX_VALUE;
            for(int i=0;i<nums.length-1;i++){
                if(seen[i])
                continue;
                int j=i+1;
                int s=0;
                while(j<nums.length&&seen[j]){
                    j++;
                }
                if(j==nums.length)
                continue;
                s=nums[i]+nums[j];
                if(s<minS){
                    minS=s;
                    l=i;
                    m=j;
                }
            }
            seen[m]=true;
            nums[l]=nums[l]+nums[m];
            ans++;
        }
        return ans;
    }
}