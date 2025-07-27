class Solution {
    int c;
    boolean[] seen;
    HashSet<Integer> set;
    List<List<Integer>> list;
    public void dfs(int i){
        if(seen[i])
        return;
        seen[i]=true;
        c++;
        for(int n:list.get(i))
        dfs(n);
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        set=new HashSet<>();
        seen=new boolean[rooms.size()];
        list=rooms;
        c=0;
        dfs(0);
        if(c!=rooms.size())
        return false;
        return true;
    }
}