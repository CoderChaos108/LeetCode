class Solution {
    List<Integer>  list=new ArrayList<>();
    int m,n;
    int[][] a;
    public void fillDown(int i,int j){
        if(i>=m||j>=n)
        return;
        list.add(a[i][j]);
        fillDown(i+1,j+1);
    }
    public void fillUp(int i,int j){
        if(i<0||j<0)
        return;
        list.add(a[i][j]);
        fillUp(i-1,j-1);
    }
    public void swapDown(int i,int j,int itr){
        if(itr>=list.size())
        return;
        a[i][j]=list.get(itr);
        swapDown(i+1,j+1,itr+1);
    }
    public void swapUp(int i,int j,int itr){
        if(itr>=list.size())
        return;
        a[i][j]=list.get(itr);
        swapUp(i-1,j-1,itr+1);
    }
    
    public int[][] sortMatrix(int[][] grid) {
        a=grid;
         m=grid.length;
         n=grid[0].length;
        for(int i=0;i<n;i++){
            fillDown(0,i);
            Collections.sort(list);
            swapDown(0,i,0);
            list=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            fillUp(m-1,i);
            Collections.sort(list);
            swapUp(m-1,i,0);
            list=new ArrayList<>();        }
        return a;
    }
}