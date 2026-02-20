class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min=Integer.MAX_VALUE;
        int xt=target[0];
        int yt=target[1];
        for(int[] a:ghosts){
            int x=a[0];
            int y=a[1];
            int dis=Math.abs(x-xt)+Math.abs(y-yt);
            min=Math.min(min,dis);
        }
        int myDis=Math.abs(xt)+Math.abs(yt);
        return myDis<min;
    }
}