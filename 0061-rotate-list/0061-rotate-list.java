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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0)
        return head;
        if(head==null)
        return null;
        ArrayList <Integer> a=new ArrayList<Integer>();
        ListNode current=head;
        while(current!=null){
            a.add(current.val);
            current=current.next;
        }   
        int t=a.size();
        k=k-(k/a.size())*a.size();
        for(int i=1;i<=k;i++){
            a.add(0,a.get(a.size()-i));
            
        }
        current=head;
        for(int i=0;i<t;i++){
            current.val=a.get(i);
            current=current.next;
        }
        return head;
    }
}