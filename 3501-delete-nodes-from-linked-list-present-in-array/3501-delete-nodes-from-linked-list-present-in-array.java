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
    HashSet<Integer> set=new HashSet<>();
    public ListNode modifiedList(int[] nums, ListNode head) {
        for(int i:nums)
        set.add(i);
        ListNode eden=null;
        ListNode current=eden;
        while(head!=null){
            if(!set.contains(head.val)){
                if(eden==null){
                    eden=new ListNode(head.val);
                    current=eden;
                    head=head.next;
                    continue;
                }
                current.next=new ListNode(head.val);
                current=current.next;
            }
            head=head.next;
        }
        return eden;
    }
}