class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        int x=points[0][0];
        int y=points[0][1];
        for(int[] a:points){
            while(true){
                if(x==a[0]&&y==a[1])
                break;
                time++;
                if(y==a[1]){
                    if(x<a[0])
                    x++;
                    else
                    x--;
                }
                else if(x==a[0]){
                    if(y<a[1])
                    y++;
                    else
                    y--;
                }
                else{
                    if(x<a[0])
                    x++;
                    else
                    x--;
                    if(y<a[1])
                    y++;
                    else
                    y--;
                }
            }
        }
        return time;
    }
}