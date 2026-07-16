class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int max=-1;
        int[] pre=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            pre[i]=gcd(max,nums[i]);
        }
        long ans=0;
        int l=0;
        int r=nums.length-1;
        Arrays.sort(pre);
        while(l<r){
            ans=ans+gcd(Math.max(pre[l],pre[r]),Math.min(pre[l],pre[r]));
            l++;
            r--;
        }
        return ans;
    }
}