class Solution {
    int[][] a;
    public boolean check(int ui,int uj){
        int li=ui+2;
        int lj=uj+2;
        boolean[] seen=new boolean[10];
        for(int i=ui;i<=li;i++){
            for(int j=uj;j<=lj;j++){
                if(a[i][j]<1||a[i][j]>9)
                return false;
                if(seen[a[i][j]])
                return false;
                seen[a[i][j]]=true;
            }
        }
        int sum=0;
        for(int i=ui;i<=li;i++){
            int s=0;
            for(int j=uj;j<=lj;j++){
                s=s+a[i][j];
            }
            if(sum==0)
            sum=s;
            if(sum!=s)
            return false;
        }
        for(int j=uj;j<=lj;j++){
            int s=0;
            for(int i=ui;i<=li;i++){
                s=s+a[i][j];
            }
            if(s!=sum)
            return false;
        }
        int diagSum=a[ui][uj]+a[ui+1][uj+1]+a[ui+2][uj+2];
        if(diagSum!=sum)
        return false;
        diagSum=a[ui][lj]+a[ui+1][lj-1]+a[ui+2][lj-2];
        if(diagSum!=sum)
        return false;
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        a=grid;
        for(int i=0;i+2<grid.length;i++){
            for(int j=0;j+2<grid[0].length;j++){
                if(check(i,j))
                ans++;
            }
        }
        return ans;
    }
}