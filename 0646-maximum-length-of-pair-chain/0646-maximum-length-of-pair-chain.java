class Solution {
    public int findLongestChain(int[][] pairs) {
     Arrays.sort(pairs,(a,b)->a[1]-b[1]);
     int[] last=pairs[0];
     int ans=1;
     int n=pairs.length;
     int k=1;
     for(int i=1;i<n;i++){
        int[] curr=pairs[i];
        int a=last[0];
        int b=last[1];
        int c=curr[0];
        int d=curr[1];
        if(b<c){
        ans++;
        last=curr;
        }
     }   
     return ans;
    }
}