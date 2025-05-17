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
    public ListNode rotateRight(ListNode head, int k) {
        int i=0;
        if(head==null)
        return head;
        ListNode current=head;
        while(current!=null){
            current=current.next;
            i++;
        }
        k=k%i;
        if(k==0)
        return head;
        current=head;
        for(int j=0;j<i-k-1;j++){
            current=current.next;
        }
        ListNode eden=current.next;
        ListNode pointer=eden;
        while(pointer.next!=null)
        pointer=pointer.next;
        current.next=null;
        pointer.next=head;
        return eden;
    }
}