class MyCircularQueue {
    ArrayList<Integer> list;
    int m;
    int f;
    int r;
    public MyCircularQueue(int k) {
        list=new ArrayList<>();
        m=k;
        f=0;
        r=0;
    }
    
    public boolean enQueue(int value) {
        if(r-f==m)
        return false;
        list.add(value);
        r++;
        return true;        
    }
    
    public boolean deQueue() {
        if(r-f==0)
        return false;
        f++;
        return true;
    }
    
    public int Front() {
        if(r-f==0)
        return -1;
        return list.get(f);
    }
    
    public int Rear() {
        if(r-f==0)
        return -1;
        return list.get(r-1);
    }
    
    public boolean isEmpty() {
        if(r-f==0)
        return true;
        return false;
    }
    
    public boolean isFull() {
        if(r-f==m)
        return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */