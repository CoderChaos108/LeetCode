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
    public int getDecimalValue(ListNode head) {
        List<Character> list=new ArrayList<>();
        while(head!=null){
            list.add((char)('0'+head.val));
            head=head.next;
        }
        int k=1;
        int m=1;
        int s=0;
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)=='1')
            s=s+m;
            m=m*2;
        }
        return s;
    }
}