class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=1;i<heights.length;i++){
            int l=heights[i-1];
            int r=heights[i];
            int need=r-l;
            if(need<=0)
            continue;
            bricks=bricks-need;
            pq.add(need);
            while(!pq.isEmpty()&&ladders>0&&bricks<0){
                ladders--;
                bricks=bricks+pq.poll();
            }
            if(bricks<0)
            return i-1;
        }
        return heights.length-1;
    }
}