class Solution {
    List<List<Integer>> list;
    HashMap<String,Integer> hm=new HashMap<>();
    public int dfs(int i,int j){
        int s=list.get(i).get(j);
        if(i==list.size()-1)
        return s;
        StringBuilder sb=new StringBuilder();
        sb.append(String.valueOf(i));
        sb.append(",");
        sb.append(String.valueOf(j));
        String str=sb.toString();
        if(hm.containsKey(str))
        return hm.get(str);
        s=s+Math.min(dfs(i+1,j),dfs(i+1,j+1));
        hm.put(str,s);
        return s;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
     list=triangle;   
     return dfs(0,0);
    }
}