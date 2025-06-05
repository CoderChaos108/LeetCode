class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int i=0;
        int n=nums.length;
        int next=0;
        boolean cycle=true;
        for(int j=0;j<n;j++){
            HashSet<Integer> set=new HashSet<>();
            i=j;
            cycle=true;      
            while(!set.contains(i)){
            set.add(i);
            next=(i+nums[i]);
            if(next>=0)
            next=next%n;
            else
            next=((i+nums[i])%n+n)%n;
            if(nums[next]*nums[i]<0){
            cycle=false;
            break;
            }
            if(next==i){
            cycle=false;
            break;
            }
            i=next;
            }
            if(cycle)
            return true;
        }
        return false;
    }
}