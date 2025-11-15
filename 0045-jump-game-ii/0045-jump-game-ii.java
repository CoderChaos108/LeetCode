class Solution {
    public int jump(int[] nums) {
        int goal=nums.length-1;
        int steps=0;
        while(goal!=0){
            int k=goal;
            for(int i=goal-1;i>=0;i--){
                if(nums[i]+i>=k)
                goal=i;
            }
            steps++;
        }
        return steps;
    }
}