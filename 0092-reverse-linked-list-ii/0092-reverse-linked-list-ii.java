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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==right)
        return head;
        ListNode current=head;
        for(int i=1;i<left;i++){
            current=current.next;
        }
        ListNode rev=null;
        ListNode temp=null;
        ListNode prev=null;
        for(int i=left;i<=right;i++){
            
            rev=new ListNode(current.val);
            if(temp!=null)
            rev.next=temp;
            temp=rev;
            current=current.next;
        }
        prev=rev;
        while(prev.next!=null)
        prev=prev.next;
        prev.next=current;
        current=head;
        if(left==1)
        return rev;
        for(int i=1;i<left-1;i++)
        current=current.next;
        current.next=rev;
        return head;
    }
}