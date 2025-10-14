class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] a:points){
            int x=a[0];
            int y=a[1];
            pq.add(new int[]{x,y,(x*x+y*y)});
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            int[] a=pq.poll();
            ans[i]=new int[]{a[0],a[1]};
        }
        return ans;
    }
}