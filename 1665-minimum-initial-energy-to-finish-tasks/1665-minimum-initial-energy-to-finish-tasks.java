class Solution {
    public int minimumEffort(int[][] tasks) {
        long r=0;
        long l=0;
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        for(int[] a:tasks){
            r=r+a[1];
        }
        // 10,12 10,11 8,9 2,4 1,3     
        long ans=Integer.MAX_VALUE;
        while(l<=r){
            long m=(l+r)/2;
            long left=m;
            for(int[] a:tasks){
                int min=a[1];
                int req=a[0];
                if(min>left){
                    left=-1;
                    break;
                }
                left=left-req;
            }
            if(left<0){
                l=m+1;
            }
            else{
                ans=m;
                r=m-1;
            }
        }
        return (int)ans;
    }
}