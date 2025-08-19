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
    public int gcd(int x,int y){
        while(y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev=head;
        ListNode succ=head.next;
        while(prev!=null&&succ!=null){
            prev.next=new ListNode(gcd(prev.val,succ.val));
            prev.next.next=succ;
            prev=succ;
            succ=succ.next;
        }
         return head;
    }
}