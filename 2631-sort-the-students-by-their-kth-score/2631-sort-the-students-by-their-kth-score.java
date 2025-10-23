class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->-score[a][k]+score[b][k]);
        int m=score.length;
        int n=score[0].length;
        for(int i=0;i<m;i++)
        pq.add(i);
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            int student=pq.poll();
            for(int j=0;j<n;j++){
                ans[i][j]=score[student][j];
            }
        }
        return ans;
    }
}