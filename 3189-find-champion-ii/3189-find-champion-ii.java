class Solution {
    boolean[] seen;
    public int findChampion(int n, int[][] edges) {
        seen=new boolean[n];
        for(int[] a:edges){
            seen[a[1]]=true;
        }
        int champ=-1;
        for(int i=0;i<n;i++){
            if(!seen[i]){
                if(champ==-1)
                champ=i;
                else
                return -1;
            }
        }
        return champ;
    }
}