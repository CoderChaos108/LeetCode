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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ListNode current=head;
        while(current!=null){
            if(current.val<x)
            a.add(current.val);
            current=current.next;
        }
        current=head;
        while(current!=null){
            if(current.val>=x)
            a.add(current.val);
            current=current.next;
        }
        current=head;
        for(int i:a){
            current.val=i;
            current=current.next;
        }
        return head;
    }
}