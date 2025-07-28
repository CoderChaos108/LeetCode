class Solution {
    boolean[] colored;
    int n;
    int b,r;
    boolean[] blue;
    int[][] a;
    HashSet<Integer> seen=new HashSet<>();
    public void color(int i,boolean b){
        if(!seen.add(i))
        return;
            colored[i]=true;
            if(b)
            blue[i]=true;
        for(int k=0;k<a[i].length;k++){
                color(a[i][k],!b);
            }
    }
    public boolean check(int i){
        for(int k=0;k<a[i].length;k++){
                if(blue[i]==blue[a[i][k]])
                return false;
            }
            return true;
    }
    public boolean isBipartite(int[][] graph) {
        n=graph.length;
        a=graph;
        colored=new boolean[n];
        blue=new boolean[n];
        for(int i=0;i<n;i++)
        color(i,true);
        for(int i=0;i<n;i++){
            if(!check(i))
            return false;
        }
        return true;
    }
}