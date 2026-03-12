class Solution {
    int[][][][] dp;
    public int find(int l,String last,int x,int y,int z){
        int state=-1;
        if(last.equals("AA"))
        state=0;
        else if(last.equals("BB"))
        state=1;
        else if(last.equals("AB"))
        state=2;
        if(state!=-1){
            if(dp[x][y][z][state]!=0)
            return dp[x][y][z][state];
        }
        int ans=l;
        if(!last.equals("AA")){
            if(x>0)
            ans=find(2+l,"AA",x-1,y,z);
            if(z>0){
                ans=Math.max(ans,find(2+l,"AB",x,y,z-1));
            }
        }
        if(!last.equals("AB")&&!last.equals("BB")&&y>0){
            ans=Math.max(ans,find(l+2,"BB",x,y-1,z));
        }
        if(state!=-1)
        dp[x][y][z][state]=ans;
        return ans;
    }
    public int longestString(int x, int y, int z) {
        dp=new int[x+1][y+1][z+1][3];
        return find(0,"",x,y,z);
    }
}