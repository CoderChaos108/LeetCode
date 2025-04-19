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
    public boolean isPalindrome(ListNode head) {
        ListNode current=head;
        StringBuilder sb=new StringBuilder();
        while(current!=null){
            sb.append(current.val);
            current=current.next;
        }
        String s=sb.toString();
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
            return false;
        }
        return true;
    }
}