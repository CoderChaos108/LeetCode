class Solution {
    int ans=0;
    boolean[] seen=new boolean[3];
    public void find(StringBuilder sb,int k){
        if(k==3){
            int val=Integer.parseInt(sb.toString(),2);
            ans=Math.max(val,ans);
        }
        for(int i=0;i<3;i++){
            if(seen[i])
            continue;
            seen[i]=true;
            String s=Integer.toBinaryString(nums[i]);
            sb.append(s);
            find(sb,k+1);
            sb.setLength(sb.length()-s.length());
            seen[i]=false;
        }
    }
    int[] nums;
    public int maxGoodNumber(int[] nums) {
        this.nums=nums;
        find(new StringBuilder(),0);
        return ans;
    }
}