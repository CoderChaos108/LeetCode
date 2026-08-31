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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode l=head;
        ListNode m=head.next;
        ListNode r=head.next.next;        
        int itr=1;        
        int firstItr=-1;        
        int lastItr=-1;         
        int min=Integer.MAX_VALUE;   
        while(r!=null){
            int lv=l.val;
            int mv=m.val;
            int rv=r.val;
            if((lv<mv&&rv<mv)||(lv>mv&&rv>mv)){
                if(firstItr==-1){
                    firstItr=itr;
                } else {
                    min=Math.min(min,itr-lastItr);
                }
                lastItr=itr;
            }
            
            l=l.next;
            m=m.next;
            r=r.next;
            itr++;
        }      
        if(firstItr==-1||firstItr==lastItr)
        return new int[]{-1,-1};     
        return new int[]{min,lastItr-firstItr};
    }
}
