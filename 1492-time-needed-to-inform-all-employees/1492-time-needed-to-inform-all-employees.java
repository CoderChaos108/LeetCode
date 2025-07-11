class Solution {
    HashMap<Integer,List<Integer>> hm;
    int[] t;
    public int time(int id){
        if(!hm.containsKey(id))
        return 0;
        int time=t[id];
        int s=0;
        for(int i:hm.get(id)){
            s=Math.max(s,time(i));
        }
        return time+s;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        t=informTime;
        hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int m=manager[i];
            if(hm.containsKey(m)){
                hm.get(m).add(i);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                hm.put(m,list);
            }
        }
        return time(headID);
    }
}