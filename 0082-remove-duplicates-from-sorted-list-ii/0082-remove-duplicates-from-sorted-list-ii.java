
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode eden=new ListNode();
        ListNode pointer=eden;
        ListNode current=head;
        while(current!=null){
            if(current.next==null||current.val!=current.next.val){
            pointer.next=new ListNode(current.val);
            pointer=pointer.next;
        }
        if(current.next==null)
        break;
        while(current.next!=null&&current.val==current.next.val){
            if(current.next==null)
            return eden;
            current=current.next;
        }
        current=current.next;
        }
        pointer=eden;
        pointer=pointer.next;
        return pointer;
    }
}