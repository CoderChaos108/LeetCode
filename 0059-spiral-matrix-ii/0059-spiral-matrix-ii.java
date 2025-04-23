class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a=new int[n][n];
        if(n==1){
            a[0][0]=1;
            return a;
        }
        int u=0;
        int b=n-1;
        int l=0;
        int r=n-1;
        int k=1;
        while(k!=n*n+1){
            for(int i=l;i<=r;i++){
                if(a[u][i]!=0||k==n*n+1)
                return a;
                a[u][i]=k;
                k++;
            }
            for(int i=u+1;i<=b;i++){
                if(a[i][r]!=0||k==n*n+1)
                return a;
                a[i][r]=k;
                k++;
            }
            for(int i=r-1;i>=l;i--){
                if(a[b][i]!=0||k==n*n+1)
                return a;
                a[b][i]=k;
                k++;
            }
            for(int i=b-1;i>=u+1;i--){
                if(a[i][l]!=0||k==n*n+1)
                return a;
                a[i][l]=k;
                k++;
            }
            u++;
            l++;
            b--;
            r--;
        }
        return a;
    }
}