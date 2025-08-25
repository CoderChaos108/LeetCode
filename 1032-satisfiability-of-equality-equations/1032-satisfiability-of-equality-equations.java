class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    List<String> queries=new ArrayList<>();
    boolean[] seen=new boolean[26];
    HashSet<List<Integer>> set=new HashSet<>();
    List<Integer> list;
    public boolean check(int x,int y){
        if(seen[x]||set.contains(list))
        return true;
        seen[x]=true;
        if(x==y)
        return false;
        for(int neigh:graph.get(x)){
        if(!check(neigh,y))
        return false;
        }
        return true;
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++)
            graph.add(new ArrayList<>());
        for(String s:equations){
            if(s.charAt(1)=='!')
            queries.add(s);
            else{
                int x=s.charAt(0)-'a';
                int y=s.charAt(3)-'a';
                if(x==y)
                continue;
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
        }
        for(String s:queries){
             seen=new boolean[26];
            int x=s.charAt(0)-'a';
            int y=s.charAt(3)-'a';
            int sizeX=graph.get(x).size();
            int sizeY=graph.get(y).size();
            list=Arrays.asList(x,y);
            Collections.sort(list);
            if(x==y)
            return false;
            if(sizeX==0||sizeY==0)
            continue;
            if(!check(x,y))
            return false;
           set.add(list);
        }
        return true;
    }
}