class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int d=0;
        for(int[] a:courses){
            int dur=a[0];
            int dead=a[1];
            d=d+dur;
            pq.add(dur);
            if(d>dead)
            d=d-pq.poll();
        }
        return pq.size();
    }
}