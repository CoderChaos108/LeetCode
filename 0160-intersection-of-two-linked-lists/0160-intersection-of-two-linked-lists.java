/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        boolean lapa=false;
        boolean lapb=false;
        while(a!=null||b!=null){
            if(a==b)
            return a;
            if(a!=null)
            a=a.next;
            if(b!=null)
            b=b.next;
            if(a==null&&!lapa){
            a=headB;
            lapa=!lapa;
            }
            if(b==null&&!lapb){
            b=headA;
            lapb=!lapb;
            }
            
        }
        return null;
    }
}