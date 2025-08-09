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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1=null;
        ListNode current=head;
        int n=1;
        for(int i=0;i<k-1;i++){
        current=current.next;
        n++;
        }
        n1=current;
        while(current.next!=null){
            current=current.next;
            n++;
        }
        current=head;
        for(int i=0;i<n-k;i++)
        current=current.next;
        int temp=n1.val;
        n1.val=current.val;
        current.val=temp;
        return head;
    }
}