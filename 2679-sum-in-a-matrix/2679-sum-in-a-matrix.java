class Solution {
    public int matrixSum(int[][] nums) {
        List<Integer>[] lists=new ArrayList[nums.length];
        for(int i=0;i<nums.length;i++)
        lists[i]=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list=lists[i];
            for(int j=0;j<nums[0].length;j++){
                list.add(nums[i][j]);
            }
            Collections.sort(list);
        }
        int ans=0;
        for(int j=0;j<nums[0].length;j++){
            int largest=-1;
            for(int i=0;i<nums.length;i++){
                largest=Math.max(largest,lists[i].get(j));
            }
            ans=ans+largest;
        }
        return ans;
    }
}