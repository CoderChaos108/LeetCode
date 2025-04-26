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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        ListNode set=head;
        while(set!=null){
            while(set.next!=null&&set.next.val==set.val){
                set=set.next;
            }
            current.next=set.next;
            current=current.next;
            set=set.next;
        }
        return head;
    }
}