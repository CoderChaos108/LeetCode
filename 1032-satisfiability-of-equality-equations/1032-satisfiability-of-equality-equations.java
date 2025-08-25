class Solution {
    boolean[][] graph=new boolean[26][26];
    boolean[] seen;

    public boolean check(int x,int y){
        if(x==y)
        return true;
        if(seen[x])
        return false;
        seen[x]=true;
        for(int neigh=0;neigh<26;neigh++){
            if(graph[x][neigh]&&check(neigh,y))
            return true;
        }
        return false;
    }

    public boolean equationsPossible(String[] equations){
        for(String s:equations){
            if(s.charAt(1)=='='){
                int x=s.charAt(0)-'a';
                int y=s.charAt(3)-'a';
                if(x==y)
                 continue;
                graph[x][y]=true;
                graph[y][x]=true;
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                int x=s.charAt(0)-'a';
                int y=s.charAt(3)-'a';
                if(x==y) 
                return false;
                seen=new boolean[26];
                if(check(x,y)) 
                return false;
            }
        }
        return true;
    }
}
