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
    public int pairSum(ListNode head) {
        ListNode tail=null;
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            ListNode node=new ListNode(curr.val);
            node.next=tail;
            tail=node;
            curr=curr.next;
            n++;
        }
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans=Math.max(head.val+tail.val,ans);
            head=head.next;
            tail=tail.next;
        }
    return ans;
    }
}