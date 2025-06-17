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
    public int[] nextLargerNodes(ListNode head) {
        ListNode current=head;
        int size=0;
        ListNode prev=null;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
            size++;
        }
        int[] ans=new int[size];
        int l=0;
        int i=size-1;
        head=prev;
        while(head!=null){
            if(l>head.val){
                ans[i]=l;
                i--;
            }
            else{
                i--;
                l=head.val;
            }
            head=head.next;
        }
        return ans;
    }
}