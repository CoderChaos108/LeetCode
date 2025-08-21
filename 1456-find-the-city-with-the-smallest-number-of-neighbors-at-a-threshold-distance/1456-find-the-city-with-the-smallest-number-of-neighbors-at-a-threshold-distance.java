class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                a[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int arr[]:edges){
            int x=arr[0];
            int y=arr[1];
            int w=arr[2];
            a[x][y]=w;
            a[y][x]=w;
        }
        for(int k=0;k<n;k++){
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==k||k==j)
                continue;
                // i j>ik+kj
                if(a[i][k]!=Integer.MAX_VALUE&&a[k][j]!=Integer.MAX_VALUE)
                a[i][j]=Math.min(a[i][j],(a[i][k]+a[k][j]));
            }
         }   
        }
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int neigh=0;
            for(int j=0;j<n;j++){
                if(a[i][j]<=distanceThreshold)
                neigh++;
            }
            if(neigh<=min){
                ans=i;
                min=neigh;
            }
        }
        return ans;
    }
}