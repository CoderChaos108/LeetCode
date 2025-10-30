class Solution {
    public int findRotateSteps(String ring, String key) {
        boolean[][] seen=new boolean[ring.length()][key.length()];
        Queue<int[]> q=new LinkedList<>(); 
        q.add(new int[]{0,0,0});
        while(true){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] a=q.poll();
                int r=a[0];
                int k=a[1];
                int steps=a[2];
                if(r==-1)
                r=ring.length()-1;
                else if(r==ring.length())
                r=0;
                if(seen[r][k])
                continue;
                seen[r][k]=true;
                if(ring.charAt(r)==key.charAt(k)){
                    if(k+1==key.length())
                    return steps+1;
                    q.add(new int[]{r,k+1,steps+1});
                    continue;
                }
                q.add(new int[]{r-1,k,steps+1});
                q.add(new int[]{r+1,k,steps+1});
            }
        }
        
    }
}