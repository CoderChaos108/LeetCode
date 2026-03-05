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
    public ListNode insertionSortList(ListNode head) {
        ListNode node=head;
        while(node!=null&&node.next!=null){
            ListNode curr=node.next;
            if(curr.val<head.val){
                node.next=curr.next;
                curr.next=head;
                head=curr;
                continue;
            }
            ListNode itr=head;
            boolean broken=false;
            while(itr.next!=curr){
                ListNode next=itr.next;
                if(next.val>curr.val){
                    node.next=curr.next;
                    itr.next=curr;
                    itr.next.next=next;
                    broken=true;
                    break;
                }
                itr=itr.next;
            }
            if(node!=null&&!broken)
            node=node.next;
        }
        return head;
    }
}