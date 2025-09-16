class Solution {
    int[][] a;
    int n;
    List<List<String>> ans=new ArrayList<>();

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
            StringBuilder sb=new StringBuilder();
            boolean found=false;
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                sb.append('Q');
                found=true;
                }
                else
                sb.append('.');
            }
            if(!found)
            return;
            list.add(sb.toString());
        }
        ans.add(list);
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

    public List<List<String>> solveNQueens(int n2){
        n=n2;
        a=new int[n][n];
        backtrack(0);
        return ans;
    }
}
