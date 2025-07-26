class Solution {
    HashSet<List<Integer>> list; 
    int[][] a;
    int m,n;
    int good;
    public void ar(int i,int j,List<List<Integer>> remove,List<List<Integer>> ad){
        remove.add((Arrays.asList(i,j)));
        if(i<0||j<0||i>=m||j>=n||a[i][j]==0){
        return ;
        }
        if(a[i][j]==1)
        good--;
        a[i][j]=0;
        ad.add(Arrays.asList(i+1,j));
        ad.add(Arrays.asList(i-1,j));
        ad.add(Arrays.asList(i,j+1));
        ad.add(Arrays.asList(i,j-1));
    }
    public int orangesRotting(int[][] grid) {
       list=new HashSet<>();
       a=grid;
       m=a.length;
       n=a[0].length;
       good=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(a[i][j]==2){
                list.add(Arrays.asList(i,j));
            }
            else if(a[i][j]==1)
            good++;
        }
       }
       if(good==0)
       return 0;
       int t=0;
       while(list.size()!=0){
        t++;
        List<List<Integer>> remove=new ArrayList<>();
        List<List<Integer>> ad=new ArrayList<>();
        for(List<Integer> l:list){
            ar(l.get(0),l.get(1),remove,ad);
        }
        for(List<Integer> l:remove)
        list.remove(l);
        for(List<Integer> l:ad)
        list.add(l);
       }
       if(good==0)
       return t-2;
       return -1; 
    }
}