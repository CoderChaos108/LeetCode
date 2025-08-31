class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        int[] score=new int[n];
        for(int i=0;i<n;i++){
            int node=edges[i];
            score[node]=score[node]+i;
        }
        int ansScore=score[0];
        int ans=0;
        for(int i=1;i<n;i++){
            if(ansScore<score[i]){
                ansScore=score[i];
                ans=i;
            }
        }
        return ans;
    }
}