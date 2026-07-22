class Solution {
    boolean[][] seen;
    int n;
    int s;
    public int find(int i,int[] a,int left,int total){
        if(i>=n){
            int x=total-left;
            return Math.abs(left-x);
        }
        if(seen[i][left])
        return Integer.MAX_VALUE;
        seen[i][left]=true;
        return Math.min(find(i+1,a,left,total),find(i+1,a,left-a[i],total));
    }
    public int lastStoneWeightII(int[] stones) {
        n=stones.length;
         s=0;
        for(int w:stones)
        s=s+w;
        seen=new boolean[n][s+1];
        return find(0,stones,s,s);
    }
}