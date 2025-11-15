class Solution {
    public int jump(int[] nums) {
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int steps=0;
        boolean[] seen=new boolean[nums.length];
        while(true){
            int size=q.size();
            for(int i=0;i<size;i++){
                int idx=q.poll();
                if(idx==nums.length-1)
                return steps;
                for(int j=1;j<=nums[idx];j++){
                    if(j+idx>=nums.length)
                    break;
                    if(!seen[idx+j])
                    q.add(idx+j);
                    seen[idx+j]=true;
                }

            }
            steps++;
        }
    }
}