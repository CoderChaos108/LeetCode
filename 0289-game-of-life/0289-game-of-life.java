class Solution {
    public void gameOfLife(int[][] m) {
        int k=m.length;
        int n=m[0].length;
        int c=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                c=0;
                if(i>0&&j>0&&(m[i-1][j-1]==1||m[i-1][j-1]==-1))
                c++;
                if(i>0&&(m[i-1][j]==1||m[i-1][j]==-1))
                c++;
                if(i>0&&j<n-1&&(m[i-1][j+1]==1||m[i-1][j+1]==-1))
                c++;
                if(j>0&&(m[i][j-1]==1||m[i][j-1]==-1))
                c++;
                if(j<n-1&&(m[i][j+1]==1||m[i][j+1]==-1))
                c++;
                if(i<k-1&&j>0&&(m[i+1][j-1]==1||m[i+1][j-1]==-1))
                c++;
                if(i<k-1&&(m[i+1][j]==1||m[i+1][j]==-1))
                c++;
                if(i<k-1&&j<n-1&&(m[i+1][j+1]==1||m[i+1][j+1]==-1))
                c++;
                if(m[i][j]==1&&(c<2||c>3))
                m[i][j]=-1;
                if(m[i][j]==0&&c==3)
                m[i][j]=2;
               }
            }
            for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]==-1)
                m[i][j]=0;
                if(m[i][j]==2)
                m[i][j]=1;
            }
            }
    }
}    