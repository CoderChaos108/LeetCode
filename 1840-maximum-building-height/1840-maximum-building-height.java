class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if(restrictions.length==0)
        return n-1;
        int ans=0;
        Arrays.sort(restrictions,(a,b)-> a[0]-b[0]);
        int ret=0;
        int m=restrictions.length;
        restrictions[0][1]=Math.min(restrictions[0][0]-1,restrictions[0][1]);
        for(int i=0;i<m-1;i++){
            int k=restrictions[i+1][0]-restrictions[i][0];
            restrictions[i+1][1]=Math.min(restrictions[i+1][1],restrictions[i][1]+k);
        }
        for(int i=m-1;i>=1;i--){
            int k=restrictions[i][0]-restrictions[i-1][0];
            restrictions[i-1][1]=Math.min(restrictions[i-1][1],restrictions[i][1]+k);
        }
        if(true){
            int l=1;
            int r=restrictions[0][0];
            int len=0;
            int t=restrictions[0][1];
            int j=l;
            int k=r-l;
            int p=(len+t+k)/2;
            ans=Math.max(ans,p);
        }
        for(int i=0;i<restrictions.length-1;i++){
            int l=restrictions[i][0];
            int r=restrictions[i+1][0];
            int len=restrictions[i][1];
            int t=restrictions[i+1][1];
            int j=l;
            int k=r-l;
            int p=(len+t+k)/2;
            ans=Math.max(ans,p);
        }
        int lastIndex=restrictions[restrictions.length-1][0];
        int lastHeight=restrictions[restrictions.length-1][1];
        ans=Math.max(ans,lastHeight+(n-lastIndex));
        return ans;
    }
}