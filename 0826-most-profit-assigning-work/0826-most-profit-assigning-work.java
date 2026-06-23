class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=profit.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=difficulty[i];
            a[i][1]=profit[i];
        }
        Arrays.sort(a, (x,y)->{
            int d1=x[0];
            int p1=x[1];
            int d2=y[0];
            int p2=y[1];
            if(p1!=p2)
            return p2-p1;
            return d1-d2;
        });
        Arrays.sort(worker);
        int j=0;
        int ans=0;
        for(int i=worker.length-1;i>=0;i--){
            int w=worker[i];
            while(w<a[j][0]){
                j++;
                if(j>=n)
                return ans;
            }
            ans=ans+a[j][1];
        }
        return ans;
    }
}