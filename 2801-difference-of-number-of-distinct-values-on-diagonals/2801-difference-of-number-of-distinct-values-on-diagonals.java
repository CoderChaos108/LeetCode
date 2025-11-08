class Solution {
    int m,n;
    int[][] a;
    public int left(int i,int j){
        HashSet<Integer> set=new HashSet<>();
        i=i-1;
        j=j-1;
        int c=0;
        while(i>=0&&j>=0){
            if(set.add(a[i][j]))
            c++;
            i--;
            j--;
        }
        return c;
    }
    public int right(int i,int j){
        HashSet<Integer> set=new HashSet<>();
        i=i+1;
        j=j+1;
        int c=0;
        while(i<m&&j<n){
            if(set.add(a[i][j]))
            c++;
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