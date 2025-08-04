class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int c=-1;
        int m=maze.length;
        int n=maze[0].length;
        Queue<List<Integer>> q=new LinkedList<>();
        boolean[][] seen=new boolean[m][n];
        q.add(Arrays.asList(entrance[0],entrance[1]));
        while(!q.isEmpty()){
            int size=q.size();
            c++;
            for(int i=0;i<size;i++){
                List<Integer> list=q.poll();
                int a=list.get(0);
                int b=list.get(1);
                if(maze[a][b]=='+'||seen[a][b])
                continue;
                seen[a][b]=true;
                if((a==0||b==0||a==m-1||b==n-1)&&(a!=entrance[0]||b!=entrance[1]))
                return c;
                if(a+1<m)
                q.add(Arrays.asList(a+1,b));
                if(a-1>=0)
                q.add(Arrays.asList(a-1,b));
                if(b+1<n)
                q.add(Arrays.asList(a,b+1));
                if(b-1>=0)
                q.add(Arrays.asList(a,b-1));
            }
        }
        return -1;
    }
}