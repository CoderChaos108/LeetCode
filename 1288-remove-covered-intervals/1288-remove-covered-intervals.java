class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans=0;
        boolean[] covered=new boolean[intervals.length];
        for(int i=0;i<intervals.length;i++){
            if(covered[i])
            continue;
            int[] a=intervals[i];
            for(int j=0;j<intervals.length;j++){
                if(i==j||covered[j])
                continue;
                int[] b=intervals[j];
                if(a[0]<=b[0]&&a[1]>=b[1]){
                covered[j]=true;
                ans++;
                }
                
            }
        }
        return intervals.length-ans;
    }
}