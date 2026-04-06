class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer,List<Integer>> x=new HashMap<>();
        HashMap<Integer,List<Integer>> y=new HashMap<>();
        HashSet<List<Integer>> set=new HashSet<>();
        int max=0;
        for(int[] a:obstacles){
            int x1=a[0];
            int y1=a[1];
            set.add(Arrays.asList(x1,y1));
            if(!x.containsKey(x1))
            x.put(x1,new ArrayList<>());
            if(!y.containsKey(y1))
            y.put(y1,new ArrayList<>());
            x.get(x1).add(y1);
            y.get(y1).add(x1);
        }
        for(int x1:x.keySet()){
            Collections.sort(x.get(x1));
        }
        for(int x1:y.keySet()){
            Collections.sort(y.get(x1));
        }
        int[][] dirs = {
    {0,1},  
    {1,0},   
    {0,-1}, 
    {-1,0}   
};
        int d=0;
        int[] pos={0,0};
        for(int c:commands){
            max=Math.max(max,pos[0]*pos[0]+pos[1]*pos[1]);
            int x1=pos[0];
            int y1=pos[1];
            if (c == -1) {
            d = (d + 1) % 4;   // RIGHT turn
        } else if (c == -2) {
            d = (d + 3) % 4;   // LEFT turn
        }
            for(int i=1;i<=c;i++){
                int ni=dirs[d][0];
                int nj=dirs[d][1];
                if(set.contains(Arrays.asList(pos[0]+ni,pos[1]+nj)))
                break;
                pos[0]=pos[0]+ni;
                pos[1]=pos[1]+nj;
            }
            
        }
        max=Math.max(max,pos[0]*pos[0]+pos[1]*pos[1]);
        return max;
    }
}