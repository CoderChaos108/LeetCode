class CustomStack {
    public class ListNode{
        int val;
        ListNode next,prev;
        public ListNode(int val){
            this.val=val;
        }
    }
    int size,max;
    ListNode head,tail;
    public CustomStack(int maxSize) {
        head=null;
        max=maxSize;
        tail=null;
        size=0;
    }
    
    public void push(int x) {
        if(size==max)
        return;
        if(size==0){
            head=new ListNode(x);
            tail=head;
        }
        else{
            tail.next=new ListNode(x);
            tail.next.prev=tail;
            tail=tail.next;
        }
        size++;
    }
    
    public int pop() {
        if(size==0)
        return -1;
        size--;
        int v=tail.val;
        if(size==0){
            head=null;
            tail=null;
            return v;
        }
        tail=tail.prev;
        tail.next=null;
        return v;
    }
    
    public void increment(int k, int val) {
        int i=0;
        ListNode current=head;
        while(i<k&&current!=null){
            current.val+=val;
            current=current.next;
            i++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */