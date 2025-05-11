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
    public ListNode partition(ListNode head, int x) {
        if(head==null)
        return null;
        ListNode smallhead=new ListNode(1);
        ListNode largehead=new ListNode(1);;
        ListNode scurrent=smallhead;
        ListNode lcurrent=largehead;
        ListNode current=head;
        while(current!=null){
            if(current.val<x){
                scurrent.next=new ListNode(current.val);
                scurrent=scurrent.next;
            }
            else{
                lcurrent.next=new ListNode(current.val);
                lcurrent=lcurrent.next;
            }
            current=current.next;
        }
        largehead=largehead.next;
        smallhead=smallhead.next;
        if(smallhead==null)
        return largehead;
        scurrent.next=largehead;
        return smallhead;
    }
}