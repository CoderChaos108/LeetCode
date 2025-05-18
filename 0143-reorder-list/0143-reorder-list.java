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
    public void reorderList(ListNode head) {
        ListNode rev= null;
        ListNode temp=null;
        ListNode current=head;
        int i=0;
        ListNode eden=new ListNode(0);
        ListNode pointer=eden;
        while(current!=null){
            i++;
            pointer.next=new ListNode(current.val);
            rev=new ListNode(current.val);
            rev.next=temp;
            temp=rev;
            current=current.next;
            pointer=pointer.next;
        }
        eden=eden.next;
        current=head;
        pointer=eden;
        temp=rev;
        while(current!=null){
            current.val=pointer.val;
            current=current.next;
            if(current==null)
            break;
            current.val=temp.val;
            current=current.next;
            pointer=pointer.next;
            temp=temp.next;
        }
    }
}