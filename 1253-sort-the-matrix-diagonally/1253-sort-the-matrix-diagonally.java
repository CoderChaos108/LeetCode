class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        for(int k=m-1;k>=0;k--){
            int i=k;
            int j=0;
            while(i<m&&j<n){
                pq.add(mat[i][j]);
                i++;
                j++;
            }
            i=k;
            j=0;
            while(i<m&&j<n){
                mat[i][j]=pq.poll();
                i++;
                j++;
            }
        }
        for(int k=1;k<n;k++){
            int i=0;
            int j=k;
            while(i<m&&j<n){
                pq.add(mat[i][j]);
                i++;
                j++;
            }
            i=0;
            j=k;
            while(i<m&&j<n){
                mat[i][j]=pq.poll();
                i++;
                j++;
            }
        }
        return mat;
    }
}