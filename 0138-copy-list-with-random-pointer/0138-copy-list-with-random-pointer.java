/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;
        Node eden=new Node(head.val);
        Node set=eden;
        Node current=head;
        int x=1;
        while(current.next!=null){
            set.next=new Node(current.next.val);
            set=set.next;
            current.next.val=x;
            x++;
            current=current.next;
        }
        head.val=0;
        current=head;
        Node pointer=eden;
        while(current!=null){
            if(current.random==null){
            pointer.random=null;
            current=current.next;
            pointer=pointer.next;
            continue;
            }
            if(current.val<current.random.val){
            set=pointer;
            for(int i=0;i<current.random.val-current.val;i++)
            set=set.next;
            }
            else{
                set=eden;
            for(int i=0;i<current.random.val;i++){
                set=set.next;
            }
            }
            pointer.random=set;
            current=current.next;
            pointer=pointer.next;
        }
        return eden;
    }
}