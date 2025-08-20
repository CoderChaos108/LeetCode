class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=Integer.MAX_VALUE;
        a[k-1]=0;
        for(int i=0;i<n-1;i++){
            for(int[] arr:times){
                int x=arr[0]-1;
                int y=arr[1]-1;
                int w=arr[2];
                if(a[x]!=Integer.MAX_VALUE&&w+a[x]<a[y]){
                    a[y]=w+a[x];
                }
            }
        }
        int ans=-1;
        for(int i:a){
            if(i==Integer.MAX_VALUE)
            return -1;
            ans=Math.max(ans,i);
        }
        return ans;
    }
}