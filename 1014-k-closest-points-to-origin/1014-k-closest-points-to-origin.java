class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            int valA=a[0]*a[0]+a[1]*a[1];
            int valB=b[0]*b[0]+b[1]*b[1];
            return valA-valB;
        });
        for(int[] a:points){
            pq.add(new int[]{a[0],a[1]});
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}