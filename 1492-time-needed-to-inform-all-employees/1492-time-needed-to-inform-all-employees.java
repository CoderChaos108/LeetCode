class Solution {
    List<Integer>[] a;
    int[] t;
    public int time(int id){
        if(a[id].size()==0)
        return 0;
        int time=t[id];
        int s=0;
        for(int i:a[id]){
            s=Math.max(s,time(i));
        }
        return time+s;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        t=informTime;
        a=new ArrayList[n];
        for(int i=0;i<n;i++){
            a[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            if(i==headID)
            continue;
            int m=manager[i];
            a[m].add(i);
        }
        return time(headID);
    }
}