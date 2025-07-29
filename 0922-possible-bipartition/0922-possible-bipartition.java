class Solution {
    boolean[] a,b,seen;
    List<List<Integer>> list=new ArrayList<>(); 
    public void part(int k,int parent,boolean isA){
        if(seen[k-1])
        return;
        seen[k-1]=true;
        if(isA)
        a[k-1]=true;
        else
        b[k-1]=true;
        for(int i:list.get(k-1)){
            if(i!=parent)
            part(i,k,!isA);
        }
    }
    public boolean check(int k){
        for(int i:list.get(k-1)){
            if(a[k-1]&&a[i-1]||b[k-1]&&b[i-1])
            return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        a=new boolean[n];
        b=new boolean[n];
        seen=new boolean[n];
        for(int i=0;i<dislikes.length;i++){ 
            list.get(dislikes[i][0]-1).add(dislikes[i][1]);
            list.get(dislikes[i][1]-1).add(dislikes[i][0]);
        }
        for(int i=1;i<=n;i++){
            if(!seen[i-1])
            part(i,-1,true);
        }
        for(int i=1;i<=n;i++){
           if(check(i)==false)
           return false;
        }
        return true;
    }
}