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
    public ListNode detectCycle(ListNode head) {
        if(head==null)
        return null;
        ListNode current=head;
        
        while(current.val!=100001){
            current.val=100001;
            if(current.next==null)
            return null;
            current=current.next;
        }
        return current;
    }
}