class Solution {
    Random rand;
    int[][] p;
    int A;
    ArrayList<Integer> area;
    
    public Solution(int[][] a) {
        rand=new Random();
        area=new ArrayList<>();
        p=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            p[i][0]=a[i][0];
            p[i][1]=a[i][1];
            p[i][2]=a[i][2];
            p[i][3]=a[i][3];
            A=A+(a[i][2]-a[i][0]+1)*(a[i][3]-a[i][1]+1);
            area.add(A);
        }
    }
    
    public int[] pick() {
        int x1=0;
        int x2=0;
        int y1=0;
        int y2=0;
        int r=rand.nextInt(A);
        for(int i=0;i<area.size();i++){
            if(area.get(i)>r){
                x1=p[i][0];
                x2=p[i][2];
                y1=p[i][1];
                y2=p[i][3];
                break;
            }
        }
        int x=rand.nextInt(x2-x1+1)+x1;
        int y=rand.nextInt(y2-y1+1)+y1;
        return new int[]{x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */