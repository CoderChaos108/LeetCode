class MyCircularDeque {

    class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
    ListNode head;
    ListNode tail;
    int c;
    int s;
    public MyCircularDeque(int k) {
        head=null;
        tail=null;
        s=0;
        c=k;
    }
    
    public boolean insertFront(int value) {
        if(s==c)
        return false;
        if(s==0){
            head=new ListNode(value);
            tail=head;
        }
        else{
            ListNode temp=new ListNode(value);
            temp.next=head;
            head=temp;
        }
        s++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(s==c)
        return false;
        if(s==0){
            head=new ListNode(value);
            tail=head;
        }
        else{
            tail.next=new ListNode(value);
            tail=tail.next;
        }
        s++;
        return true;
    }
    
    public boolean deleteFront() {
        if(s==0)
        return false;
        else if(s==1){
            head=null;
            tail=null;
        }
        else{
        head=head.next;
        }
        s--;
        return true;
    }
    
    public boolean deleteLast() {
        if(s==0)
        return false;
        else if(s==1){
            head=null;
            tail=null;
        }
        else{
            ListNode current=head;
            while(current.next!=tail)
            current=current.next;
            tail=current;
        }
        s--;
        return true;
    }
    
    public int getFront() {
        if(s==0)
        return -1;
        return head.val;
    }
    
    public int getRear() {
        if(s==0)
        return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        if(s==0)
        return true;
        return false;
    }
    
    public boolean isFull() {
        if(s==c)
        return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */