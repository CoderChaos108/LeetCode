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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i=1;
        if(left==right)
        return head;
        ListNode current=head;
        
        ArrayList<Integer> a=new ArrayList<Integer>();
        while(i!=left){
            current=current.next;
            i++;
        }
        ListNode eden=current;
        while(i!=right+1){
            a.add(current.val);
            current=current.next;
            i++;
        }
        current=eden;
        for(int j=a.size()-1;j>=0;j--){
            current.val=a.get(j);
            current=current.next;
        }
            return head;
    }
}