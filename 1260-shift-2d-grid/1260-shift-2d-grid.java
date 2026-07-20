class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<m;i++){
            ans.add(new ArrayList<>());
            List<Integer> list=ans.get(i);
            for(int j=0;j<n;j++){
                list.add(0);
            }
        }

        k%=m*n;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx=i*n+j;
                int newIdx=(idx+k)%(m*n);

                int r=newIdx/n;
                int c=newIdx%n;

                ans.get(r).set(c,grid[i][j]);
            }
        }

        return ans;
    }
}