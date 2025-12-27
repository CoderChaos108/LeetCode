class Solution {
    public int mostBooked(int n, int[][] meeting) {
        int[] ans=new int[n];
        PriorityQueue<Integer> rooms=new PriorityQueue<>((a,b)->a-b);
        PriorityQueue<int[]> meetings=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> ongoing=new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int[]> stalled=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int start=Integer.MAX_VALUE;
        int end=0;
        for(int i=0;i<n;i++)
        rooms.add(i);
        for(int[] a:meeting){
        meetings.add(a);
        start=Math.min(start,a[0]);
        end=Math.max(end,a[1]);        
        }
        int i=0;
        while(!meetings.isEmpty()||!stalled.isEmpty()){
            boolean changed=false;
            int meet=-1;
            int ong=-1;
            if(!meetings.isEmpty())
            meet=meetings.peek()[0];
            if(!ongoing.isEmpty())
            ong=ongoing.peek()[1];
            if(meet!=-1&&ong!=-1)
            i=Math.min(ong,meet);
            else if(meet==-1&&ong==-1)
            i++;
            else if(ong==-1)
            i=meet;
            else if(meet==-1)
            i=ong;
            while(!ongoing.isEmpty()&&ongoing.peek()[1]==i){
                rooms.add(ongoing.poll()[0]);
            }
            while(!stalled.isEmpty()&&!rooms.isEmpty()){
                int[] a=stalled.poll();
                int room=rooms.poll();
                ongoing.add(new int[]{room,i-a[0]+a[1]});
                ans[room]++;
            }
            while(!meetings.isEmpty()&&meetings.peek()[0]==i){
                int[] a=meetings.poll();
                if(!rooms.isEmpty()){
                    int room=rooms.poll();
                    ongoing.add(new int[]{room,a[1]});
                    ans[room]++;
                }
                else{
                    stalled.add(a);
                }
            }
        }
        int mostUsed=0;
        for(int j=0;j<n;j++){
            if(ans[mostUsed]<ans[j])
            mostUsed=j;
        }
        return mostUsed;
    }
}