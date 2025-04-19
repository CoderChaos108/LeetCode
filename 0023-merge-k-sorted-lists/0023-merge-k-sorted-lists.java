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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ListNode current=null;
        int l=0;
        int s=0;
        for(ListNode i:lists){
            current=i;
            while(current!=null){
                a.add(current.val);
                current=current.next;
            }
        }
        if(a.size()==0)
        return null;
        Collections.sort(a);
        ListNode head=new ListNode(a.get(0));
         current=head;
        for(int i=1;i<a.size();i++){
            current.next=new ListNode(a.get(i));
            current=current.next;
        }
        return head;
    }
}