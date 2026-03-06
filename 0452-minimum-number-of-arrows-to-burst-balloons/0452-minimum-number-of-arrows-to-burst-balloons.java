class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        boolean[] merged=new boolean[points.length];
        for(int i=0;i<points.length-1;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            int x2=points[i+1][0];
            int y2=points[i+1][1];
            if(y1>=x2){
                merged[i]=true;
                points[i+1][0]=x2;
                points[i+1][1]=Math.min(y1,y2);
            }
        }
        int ans=0;
        for(int i=0;i<points.length;i++){
            if(!merged[i])
            ans++;
        }
        return ans;
    }
}