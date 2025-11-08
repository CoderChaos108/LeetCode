class Solution {
    int m,n;
    int[][] a;
    public int left(int i,int j){
        boolean[] arr=new boolean[51];
        i=i-1;
        j=j-1;
        int c=0;
        while(i>=0&&j>=0){
            if(!arr[a[i][j]])
            c++;
            arr[a[i][j]]=true;
            i--;
            j--;
        }
        return c;
    }
    public int right(int i,int j){
        boolean[] arr=new boolean[51];
        i=i+1;
        j=j+1;
        int c=0;
        while(i<m&&j<n){
            if(!arr[a[i][j]])
            c++;
            arr[a[i][j]]=true;
            i++;
            j++;
        }
        return c;
    }
    
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] ans;
        a=grid;
        m=a.length;
        n=a[0].length;
        ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=Math.abs(left(i,j)-right(i,j));
            }
        }
        return ans;
    }
}