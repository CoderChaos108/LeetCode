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
    public ListNode doubleIt(ListNode head) {
        ListNode rev=null;
        ListNode temp=null;
        ListNode current=head;
        while(current!=null){
            rev=new ListNode(current.val);
            rev.next=temp;
            temp=rev;
            current=current.next;
        }
        int p=0;
        int c=0;
        current=rev;
        while(current!=null){
            p=current.val*2+c;
            current.val=p%10;
            c=p/10;
            current=current.next;
        }
        current=rev;
        temp=null;
        while(current!=null){
            head=new ListNode(current.val);
            head.next=temp;
            temp=head;
            current=current.next;
        }
        if(c>0){
            current=new ListNode(c);
            current.next=head;
            return current;
        }
        return head;
    }
}