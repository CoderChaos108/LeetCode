class SeatManager {
    PriorityQueue<Integer> pq;;
    boolean[] res;
    public SeatManager(int n) {
        pq=new PriorityQueue<>((a,b)->a-b);
        res=new boolean[n+1];
        for(int i=1;i<=n;i++){
            pq.add(i);
        }
    }
    
    public int reserve() {
        while(true){
            int num=pq.poll();
            if(res[num])
            continue;
            res[num]=true;
            return num;
        }
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
        res[seatNumber]=false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */