class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        HashSet<String> seen=new HashSet<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int t=0;t<size;t++){
                int[] a=q.poll();
                int i=a[0];
                int j=a[1];
                if(i+j==target)
                return true;
                if(!seen.add(i+","+j))
                continue;
                q.add(new int[]{x,j});
                q.add(new int[]{i,y});
                q.add(new int[]{0,j});
                q.add(new int[]{i,0});
                int fill=Math.min(y-j,i);
                q.add(new int[]{i-fill,j+fill});
                fill=Math.min(x-i,j);
                q.add(new int[]{i+fill,j-fill});
            }
        }
        return false;
    }
}