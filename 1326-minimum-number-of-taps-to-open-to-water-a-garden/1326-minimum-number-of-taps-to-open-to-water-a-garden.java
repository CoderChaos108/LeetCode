class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] taps=new int[n+1][2];
        for(int i=0;i<=n;i++){
            int l=Math.max(0,i-ranges[i]);
            int r=Math.min(n,i+ranges[i]);
            taps[i][0]=l;
            taps[i][1]=r;
        }
        Arrays.sort(taps,(a,b)->a[0]-b[0]);
        int ans=0;
        int covered=0;
        int i=0;
        while(covered<n&&i<=n){
            ans++;
            int max=-1;
            int j=i;
            while(j<=n&&taps[j][0]<=covered){
                max=Math.max(max,taps[j][1]);
                j++;
            }
            i=j;
            if(max<=covered)
            return -1;
            covered=max;
        }
        if(covered>=n)
        return ans;
        return -1;
    }
}