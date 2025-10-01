class Solution {
    public class Pair{
        int row,col;
        List<Integer> list;
        public Pair(int i,int j,List<Integer> list){
            row=i;
            col=j;
            this.list=new ArrayList<>(list);
        }
    }
    HashSet<List<Integer>> set=new HashSet<>();
    List<Integer> winSet=Arrays.asList(1,2,3,4,5,0);
    public int slidingPuzzle(int[][] board) {
        List<Integer> start=new ArrayList<>();
        int i0=0;
        int j0=0;
        for(int i2=0;i2<2;i2++){
            for(int j2=0;j2<3;j2++){
                if(board[i2][j2]==0){
                    i0=i2;
                    j0=j2;
                }
                start.add(board[i2][j2]);
            }
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i0,j0,start));
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                Pair p=q.poll();
                int i=p.row;
                int j=p.col;
                List<Integer> list=p.list;
                if(!set.add(list))
                continue;
                if(list.equals(winSet))
                return steps;
                int place=3*i+j;
                if(i!=0){
                    int i1=i-1;
                    int j1=j;
                    int newPlace=3*i1+j1;
                    int temp=list.get(place);
                    list.set(place,list.get(newPlace));
                    list.set(newPlace,temp);
                    if(!set.contains(list))
                    q.add(new Pair(i1,j1,list));
                    list.set(newPlace,list.get(place));
                    list.set(place,temp);
                }
                if(j!=0){
                    int i1=i;
                    int j1=j-1;
                    int newPlace=3*i1+j1;
                    int temp=list.get(place);
                    list.set(place,list.get(newPlace));
                    list.set(newPlace,temp);
                    if(!set.contains(list))
                    q.add(new Pair(i1,j1,list));
                    list.set(newPlace,list.get(place));
                    list.set(place,temp);
                }
                if(i!=1){
                    int i1=i+1;
                    int j1=j;
                    int newPlace=3*i1+j1;
                    int temp=list.get(place);
                    list.set(place,list.get(newPlace));
                    list.set(newPlace,temp);
                    if(!set.contains(list))
                    q.add(new Pair(i1,j1,list));
                    list.set(newPlace,list.get(place));
                    list.set(place,temp);
                }
                if(j!=2){
                    int i1=i;
                    int j1=j+1;
                    int newPlace=3*i1+j1;
                    int temp=list.get(place);
                    list.set(place,list.get(newPlace));
                    list.set(newPlace,temp);
                    if(!set.contains(list))
                    q.add(new Pair(i1,j1,list));
                    list.set(newPlace,list.get(place));
                    list.set(place,temp);
                }
            }
            steps++;
        }
        return -1;
    }
}