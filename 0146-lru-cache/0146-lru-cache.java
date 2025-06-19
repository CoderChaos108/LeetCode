class LRUCache {
    class ListNode {
        ListNode prev,next;
        int val,key;
        ListNode(int val,int key) {
            this.val=val;
            this.key=key;
        }
    }

    int size,k;
    HashMap<Integer,ListNode> hm;
    ListNode head,tail;

    public LRUCache(int capacity) {
        k=capacity;
        size=0;
        hm=new HashMap<>();
        head=null;
        tail=null;
    }

    public int get(int key) {
        if(!hm.containsKey(key))
        return -1;
        ListNode node=hm.get(key);
        if(node!=tail) {
            if(node==head) {
                head=head.next;
                if(head!=null)
                head.prev=null;
            } else {
                if(node.next!=null)
                node.next.prev=node.prev;
                if(node.prev!=null)
                node.prev.next=node.next;
            }
            node.prev=tail;
            node.next=null;
            tail.next=node;
            tail=node;
        }
        return tail.val;
    }

    public void put(int key,int value) {
        if(!hm.containsKey(key)) {
            ListNode node=new ListNode(value,key);
            if(tail!=null) {
                tail.next=node;
                node.prev=tail;
                tail=node;
            } else
            head=tail=node;
            hm.put(key,node);
            size++;
            if(size>k) {
                hm.remove(head.key);
                head=head.next;
                if(head!=null)
                head.prev=null;
                size--;
            }
        } else {
            ListNode node=hm.get(key);
            node.val=value;
            if(node!=tail) {
                if(node==head) {
                    head=head.next;
                    if(head!=null)
                    head.prev=null;
                } else {
                    if(node.next!=null)
                    node.next.prev=node.prev;
                    if(node.prev!=null)
                    node.prev.next=node.next;
                }
                node.prev=tail;
                node.next=null;
                tail.next=node;
                tail=node;
            }
        }
    }
}
