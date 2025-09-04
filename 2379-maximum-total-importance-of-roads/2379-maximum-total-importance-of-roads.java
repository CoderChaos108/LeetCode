class Solution {
    public long maximumImportance(int n, int[][] roads) {
     int[] values=new int[n];
     int[] degrees=new int[n];
     Integer[] nodes=new Integer[n];
     for(int[] a:roads){
        degrees[a[0]]++;
        degrees[a[1]]++;
     }
    for(int i=0;i<n;i++){
        nodes[i]=i;
    }
    Arrays.sort(nodes,(a,b)->(degrees[a]-degrees[b]));
    for(int i=1;i<=n;i++){
        values[nodes[i-1]]=i;
    }
    long ans=0;
    for(int[] a:roads){
        ans=ans+values[a[0]]+values[a[1]];
    }
    return ans;
    }
}