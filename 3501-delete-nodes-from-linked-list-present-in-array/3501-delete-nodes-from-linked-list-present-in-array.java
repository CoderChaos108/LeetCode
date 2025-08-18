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
    public ListNode recur(ListNode node){
        if(node==null)
        return null;
        if(set.contains(node.val)){
            return recur(node.next);
        }
        else
        node.next=recur(node.next);
        return node;
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        for(int i:nums)
        set.add(i);
        return recur(head);
    }
}