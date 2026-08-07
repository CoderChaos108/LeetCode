class Solution {
    public int videoStitching(int[][] clips, int time) {
        int covered=0;
        boolean vital=true;
        Arrays.sort(clips,(a,b)->{
            if(a[0]!=b[0])
            return a[0]-b[0];
            return b[1]-a[1];
        });
        int ans=0;
        int n=clips.length;
        int i=0;
        while(covered<time&&i<n){
            int max=-1;
            int j=i;
            while(j<n&&clips[j][0]<=covered){
                max=Math.max(max,clips[j][1]);
                j++;
            }
            if(max<=covered)
            return -1;
            covered=max;
            i=j;
            ans++;
        }
        if(covered>=time)
        return ans;
        return -1;
    }
}