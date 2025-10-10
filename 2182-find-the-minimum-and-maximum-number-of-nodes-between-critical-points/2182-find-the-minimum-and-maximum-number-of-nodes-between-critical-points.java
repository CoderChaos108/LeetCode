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
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        while(r!=null){
            int lv=l.val;
            int mv=m.val;
            int rv=r.val;
            if((lv<mv&&rv<mv)||(lv>mv&&rv>mv)){
            list.add(itr);
            if(list.size()>=2){
                min=Math.min(min,itr-list.get(list.size()-2));
            }
            }
            l=l.next;
            m=m.next;
            r=r.next;
            itr++;
        }
        if(list.size()<2)
        return new int[]{-1,-1};
        return new int[]{min,list.get(list.size()-1)-list.get(0)};
    }
}