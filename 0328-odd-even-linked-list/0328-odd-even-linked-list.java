/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
        return null;
        if(head.next==null)
        return head;
        ListNode current =head;
        ListNode eden=new ListNode(current.val);
        ListNode pointer=eden;
        while(current.next!=null&&current.next.next!=null){
            current=current.next.next;
            pointer.next=new ListNode(current.val);
            pointer=pointer.next;
        }
        current=head;
        current=current.next;
     
        while(current.next!=null&&current.next.next!=null){
            pointer.next=new ListNode(current.val);
            current=current.next.next;
            
            pointer=pointer.next;
        }
        pointer.next=new ListNode(current.val);
        return eden;
    }
}