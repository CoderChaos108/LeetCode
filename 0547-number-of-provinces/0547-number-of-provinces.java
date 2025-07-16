class Solution {
    HashMap<Integer,List<Integer>> hm;
    HashSet<Integer> seen;
    public int check(int n){
        if(seen.add(n)){
            for(int i:hm.get(n))
            check(i);
            return 1;
        }
        else
        return 0;
    }
    public int findCircleNum(int[][] isConnected) {
        seen=new HashSet<>();
         hm=new HashMap<>();
        for(int i=0;i<isConnected.length;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1)
                list.add(j);
            }
            hm.put(i,list);
        }
        int c=0;
        for(int i=0;i<isConnected.length;i++)
        c=c+check(i);
        return c;
    }
}