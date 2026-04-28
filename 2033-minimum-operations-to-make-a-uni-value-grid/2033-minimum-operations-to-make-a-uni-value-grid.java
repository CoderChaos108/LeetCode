class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid[0].length;
        int m=grid.length;
        int[] a=new int[m*n];
        int itr=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[itr++]=grid[i][j];
            }
        }
        Arrays.sort(a);
        int val=a[a.length/2];
        int ans=0;
        for(int i:a){
            if(i%x!=val%x)
            return -1;
            ans=ans+Math.abs(i-val)/x;
        }
        return ans;
    }
}