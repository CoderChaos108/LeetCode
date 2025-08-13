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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
        return null;
        int n=0;
        ListNode current=head;
        while(current.next!=null){
            n++;
            current=current.next;
        }
        current=head;
        if(n%2==0)
        n=n/2-1;
        else
        n=n/2;
        for(int i=0;i<n;i++){
            current=current.next;
        }
        current.next=current.next.next;
        return head;
    }
}