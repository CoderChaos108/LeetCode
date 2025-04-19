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
    public ListNode swapPairs(ListNode head) {
        ListNode current=head;
        if(current==null)
        return head;
        if(current.next==null)
        return head;
        ListNode prev=null;
        int k1=0;
        int k2=0;
        while(current!=null){
            if(current.next==null)
            return head;
            k1=current.val;
            prev=current;
            current=current.next;
            k2=current.val;
            current.val=k1;
            current=prev;
            current.val=k2;
            current=current.next;
            current=current.next;
        }
        return head;
    }
}