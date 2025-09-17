class Solution {
    int[][] a;
    int n;
    int c=0;

    public void prune(int i,int j){
        for(int r=i+1;r<n;r++){
            a[r][j]--;
        }
        for(int r=i+1,c=j+1;r<n&&c<n;r++,c++){
            a[r][c]--;
        }
        for(int r=i-1,c=j+1;r>=0&&c<n;r--,c++){
            a[r][c]--;
        }
    }

    public void reset(int i,int j){
        for(int r=i+1;r<n;r++){
            a[r][j]++;
        }
        for(int r=i+1,c=j+1;r<n&&c<n;r++,c++){
            a[r][c]++;
        }
        for(int r=i-1,c=j+1;r>=0&&c<n;r--,c++){
            a[r][c]++;
        }
    }

    public void fill(List<String> list){
        for(int i=0;i<n;i++){
            boolean found=false;
            for(int j=0;j<n;j++){
                if(a[i][j]==1)
                found=true;
            }
            if(!found)
            return;
        }
        c++;
    }

    public void backtrack(int i){
        if(i==n){
            fill(new ArrayList<>());
            return;
        }
        for(int j=0;j<n;j++){
            if(a[i][j]!=0)
            continue;
            a[i][j]=1;
            prune(i,j);
            backtrack(i+1);
            reset(i,j);
            a[i][j]=0;
        }
    }

    public int totalNQueens(int n2) {
        n=n2;
        a=new int[n][n];
        backtrack(0);
        return c;
    }
}
