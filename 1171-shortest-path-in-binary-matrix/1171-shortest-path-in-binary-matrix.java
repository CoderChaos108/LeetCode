class Solution {
    Queue<Integer> i=new LinkedList<>();
    Queue<Integer> j=new LinkedList<>();
    int[][] ar;
    boolean[][] seen;
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        ar=grid;
        int c=0;
        n=ar.length;
        seen=new boolean[n][n];
        if(ar[0][0]!=0||ar[n-1][n-1]!=0)
        return -1;
        i.add(0);
        j.add(0);
        while(!i.isEmpty()){
            int size=i.size();
            c++;
            for(int k=0;k<size;k++){
            int a=i.poll();
            int b=j.poll();
            if(a<0||b<0||a>=n||b>=n||seen[a][b]||ar[a][b]==1)
            continue;
            seen[a][b]=true;
            if(a==n-1&&b==n-1)
            return c;
            i.add(a-1);
            j.add(b-1);
            i.add(a-1);
            j.add(b);
            i.add(a-1);
            j.add(b+1);
            i.add(a);
            j.add(b-1);
            i.add(a);
            j.add(b+1);
            i.add(a+1);
            j.add(b-1);
            i.add(a+1);
            j.add(b);
            i.add(a+1);
            j.add(b+1);
            }
         }
         return -1;
    }
}