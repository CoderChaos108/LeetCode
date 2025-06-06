class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }
    ListNode head,tail;
    int size;

    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    public int get(int index) {
        if(index<0||index>=size) return -1;
        ListNode current=head;
        for(int i=0;i<index;i++)current=current.next;
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode add=new ListNode(val);
        add.next=head;
        head=add;
        if(tail==null)tail=head;
        size++;
    }

    public void addAtTail(int val) {
        ListNode add=new ListNode(val);
        if(tail==null){
            head=add;
            tail=add;
        }else{
            tail.next=add;
            tail=add;
        }
        size++;
    }

    public void addAtIndex(int index,int val) {
        if(index<0||index>size) return;
        if(index==0){
            addAtHead(val);
        }else if(index==size){
            addAtTail(val);
        }else{
            ListNode current=head;
            for(int i=1;i<index;i++)current=current.next;
            ListNode add=new ListNode(val);
            add.next=current.next;
            current.next=add;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;
        if(index==0){
            head=head.next;
            if(head==null)tail=null;
            size--;
            return;
        }
        ListNode current=head;
        for(int i=0;i<index-1;i++)current=current.next;
        if(current.next==tail)tail=current;
        current.next=current.next.next;
        size--;
    }
}
