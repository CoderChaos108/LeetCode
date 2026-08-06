class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            int l1=a[0];
            int l2=b[0];
            int r1=a[1];
            int r2=b[1];
            if(l1!=l2)
            return l1-l2;
            return r1-r2;
        });
        int removed=0;
        int n=intervals.length;
        int[] a=intervals[0];
        for(int i=1;i<n;i++){

            int[] b=intervals[i];
             int l1=a[0];
            int l2=b[0];
            int r1=a[1];
            int r2=b[1];
            if(l2<r1){
                removed++;
                if(r2<r1)
                a=b;
            }
            else
            a=b;
        }
        return removed;
    }
}