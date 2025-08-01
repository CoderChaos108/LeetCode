class Solution {
    int[][] a;
    int m,n;
    int c=0;
    int[][] l;

    public int check(int i,int j,int parent){
        if(i<0||j<0||i>=m||j>=n||a[i][j]<=parent)
            return 0;

        if(l[i][j]!=0)
            return l[i][j];

        int streak=0;
        streak=Math.max(streak,check(i+1,j,a[i][j]));
        streak=Math.max(streak,check(i-1,j,a[i][j]));
        streak=Math.max(streak,check(i,j+1,a[i][j]));
        streak=Math.max(streak,check(i,j-1,a[i][j]));

        l[i][j]=1+streak;
        return l[i][j];
    }

    public int longestIncreasingPath(int[][] matrix){
        a=matrix;
        m=a.length;
        n=a[0].length;
        l=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c=Math.max(c,check(i,j,-1));
            }
        }
        return c;
    }
}
