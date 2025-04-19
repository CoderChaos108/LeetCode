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
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ListNode current=head;
        while(current!=null){
            a.add(current.val);
            current=current.next;
        }
        current=head;
        for(int i=a.size()-1;i>=0;i--){
            current.val=a.get(i);
            current=current.next;
        }
        return head;
    }
}