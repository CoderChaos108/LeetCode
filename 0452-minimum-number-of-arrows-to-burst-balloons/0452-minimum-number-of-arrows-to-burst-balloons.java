class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));

        LinkedList<int[]> list=new LinkedList<>();
        for(int[] p:points){
            list.add(p);
        }

        ListIterator<int[]> it=list.listIterator();
        int[] curr=it.next();

        while(it.hasNext()){
            int[] next=it.next();

            int x1=curr[0];
            int y1=curr[1];
            int x2=next[0];
            int y2=next[1];

            if(y1>=x2){
                curr[0]=x2;
                curr[1]=Math.min(y1,y2);
                it.remove();
            }else{
                curr=next;
            }
        }

        int ans=list.size();
        return ans;
    }
}