class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
            StringBuilder sb=new StringBuilder();
            List<Boolean> list=new ArrayList<>();
            int s=0;
            for(int i=0;i<nums.length;i++){
                s=(2*s+(nums[i]))%5;
                list.add(s%5==0);
            }
            return list;
    }
}