class Solution {
    public int[] singleNumber(int[] nums) {
     HashMap<Integer,Integer> hm=new HashMap<>();
     int a[]={0,0};
     int t=0;
     for(int i=0;i<nums.length;i++){
        if(hm.containsKey(nums[i])==false){
            hm.put(nums[i],1);
        }
        else
        hm.put(nums[i],2);
     }   
     for(int i:nums){
        if(hm.get(i)==1){
            if(t==0){
                a[t]=i;
                t=1;
            }
            else
            a[1]=i;
        }

     }
     return a;
    }
}