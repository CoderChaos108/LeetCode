class Solution {
    public int matrixSum(int[][] nums) {
        List<Integer>[] lists=new ArrayList[nums.length];
        
        for(int i=0;i<nums.length;i++){
            Arrays.sort(nums[i]);
        }
        int ans=0;
        for(int j=0;j<nums[0].length;j++){
            int largest=-1;
            for(int i=0;i<nums.length;i++){
                largest=Math.max(largest,nums[i][j]);
            }
            ans=ans+largest;
        }
        return ans;
    }
}