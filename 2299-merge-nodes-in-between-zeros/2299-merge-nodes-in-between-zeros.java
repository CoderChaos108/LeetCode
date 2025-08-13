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
    public ListNode mergeNodes(ListNode head) {
        ListNode current=head.next;
        ListNode eden=new ListNode(-1);
        ListNode pointer=eden;
        int s=0;
        while(current!=null){
            if(current.val==0){
                pointer.next=new ListNode(s);
                pointer=pointer.next;
                if(eden.val==-1)
                eden=pointer;
                s=0;
            }
            else{
                s=s+current.val;
                
            }
            current=current.next;
        }
        return eden;
    }
}