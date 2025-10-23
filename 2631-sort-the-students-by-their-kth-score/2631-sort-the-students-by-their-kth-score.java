class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m=score.length;
        int n=score[0].length;
        Arrays.sort(score,(a,b)->b[k]-a[k]);
        return score;
    }
}