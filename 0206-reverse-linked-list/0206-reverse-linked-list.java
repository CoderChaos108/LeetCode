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
    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode temp=null;
        ListNode rev=null;
        // 1  2   3   4   5   6   7   8
        while(current!=null){
            rev=new ListNode(current.val);
            if(temp!=null)
            rev.next=temp;
            temp=rev;
            current=current.next;
        }
        return rev;
    }
}