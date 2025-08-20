class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        a[i]=Integer.MAX_VALUE;
        a[src]=0;
        for(int i=0;i<k+1;i++){
            int[] temp=a.clone();
            for(int[] arr:flights){
                int from=arr[0];
                int to=arr[1];
                int w=arr[2];
                if(a[from]!=Integer.MAX_VALUE&&a[from]+w<temp[to])
                temp[to]=w+a[from];
            }
            a=temp;
        }
        if(a[dst]==Integer.MAX_VALUE)
        return -1;
        return a[dst];
    }
}