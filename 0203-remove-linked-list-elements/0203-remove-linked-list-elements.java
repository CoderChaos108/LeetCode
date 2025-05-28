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
    public ListNode removeElements(ListNode head, int val) {
        ListNode current=head;
        ListNode temp=null;
        while(current!=null&&current.next!=null){
            if(current.next.val==val){
                temp=current.next;
                while(temp!=null&&temp.val==val)
                temp=temp.next;
                current.next=temp;
            }
            current=current.next;
        }
        if(head!=null&&head.val==val)
        head=head.next;
        return head;
    }
}