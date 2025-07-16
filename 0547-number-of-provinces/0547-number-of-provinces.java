class Solution {
    HashSet<Integer> seen;
    public int check(int n,int[][] m){
        if(seen.add(n)){
            for(int j=0;j<m[0].length;j++){
                if(m[n][j]==1)
                check(j,m);
            }
            return 1;
        }
        else
        return 0;
    }
    public int findCircleNum(int[][] isConnected) {
        seen=new HashSet<>(); 
        int c=0;
        for(int i=0;i<isConnected.length;i++)
        c=c+check(i,isConnected);
        return c;
    }
}