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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode alphaLink=null;
        ListNode omegaLink=null;
        ListNode current=list1;
        for(int i=0;i<a-1;i++){
            current=current.next;
        }
        alphaLink=current;
        for(int i=a-2;i<b;i++){
            current=current.next;
        }
        omegaLink=current;
        current=list2;
        while(current.next!=null)
        current=current.next;
        alphaLink.next=list2;
        current.next=omegaLink;
        return list1;
    }
}