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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
        set.add(i);
        int c=0;
        boolean con=false;
        ListNode current=head;
        while(current!=null){
            if(set.contains(current.val))
            con=true;
            if(con&&!set.contains(current.val)){
                c++;
                con=false;
            }
            current=current.next;
        }
        if(con)
        c++;
        return c;
    }
}