class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m=score.length;
        int n=score[0].length;
        Integer[] a=new Integer[m];
        for(int i=0;i<m;i++)
        a[i]=i;
        Arrays.sort(a,(x,y)->score[y][k]-score[x][k]);
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            int student=a[i];
            for(int j=0;j<n;j++){
                ans[i][j]=score[student][j];
            }
        }
        return ans;
    }
}