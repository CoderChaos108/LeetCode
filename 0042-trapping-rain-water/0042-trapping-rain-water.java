class Solution {
    public int trap(int[] height) {
        int[] prefix=new int[height.length];
        int[] suffix=new int[height.length];
        int n=height.length;
        int l=0;
        int r=n-1;
        while(l<n&&height[l]==0)
        l++;
        while(r>=0&&height[r]==0)
        r--;
        int pre=0;
        for(int i=l;i<=r;i++){
            pre=Math.max(pre,height[i]);
            prefix[i]=pre;
        }
        int suf=0;
        for(int i=r;i>=l;i--){
            suf=Math.max(suf,height[i]);

            suffix[i]=suf;
        }
        int ans=0;
        for(int i=l;i<=r;i++){
            int h=height[i];
            int left=prefix[i];
            int right=suffix[i];
            if(left==h||right==h)
            continue;
            ans=ans+Math.min(left,right)-h;
        }
        return ans;
    }
}