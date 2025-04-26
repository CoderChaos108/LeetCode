/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
        return false;
        if(head.next==null)
        return false;
        ListNode hare=head;
        ListNode turtle=head;
        do{
            if(hare.next==null||hare.next.next==null)
            return false;
            hare=hare.next.next;
            turtle=turtle.next;
        }while(hare!=turtle);
        return true;
    }
}