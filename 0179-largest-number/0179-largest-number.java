class Solution {
    public String largestNumber(int[] nums) {
        boolean allZeros=true;
        for(int i:nums){
            if(i!=0){
            allZeros=false;
            break;
            }
        }
        if(allZeros)
        return "0";
        String[] arr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b)->{
            String s1=a+b;
            String s2=b+a;
            for(int i=0;i<s1.length();i++){
                char c1=s1.charAt(i);
                char c2=s2.charAt(i);
                if(c1!=c2){
                    return -(c1-c2);
                }
            }
            return 1;
        });
        StringBuilder sb=new StringBuilder();
        for(String s:arr)
        sb.append(s);
        return sb.toString();
    }
}