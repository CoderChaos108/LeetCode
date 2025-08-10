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
    public ListNode middleNode(ListNode head) {
        int n=0;
        ListNode current=head;
        while(current.next!=null){
            n++;
            current=current.next;
        }
        if(n%2!=0)
        n=n/2+1;
        else
        n=n/2;
        for(int i=0;i<n;i++){
            head=head.next;
        }
        return head;
    }
}