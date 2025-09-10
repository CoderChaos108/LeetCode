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
    public ListNode removeNodes(ListNode head) {
        ListNode current=head;
        ListNode temp=null;
        ListNode prev=null;
        int n=0;
        while(current!=null){
            n++;
            temp=new ListNode(current.val);
            temp.next=prev;
            prev=temp;
            current=current.next;
        }
        current=prev.next;
        Queue<ListNode> q=new LinkedList<>();
        q.add(prev);
        while(current!=null){
            while(!q.isEmpty()&&q.peek().val<current.val)
            q.remove();
            if(q.isEmpty()||q.peek().val==current.val)
            q.add(current);
            else
            current.val=-1;
            current=current.next;
        }
        ListNode eden=null;
        while(prev!=null){
            if(prev.val!=-1){
                ListNode node=new ListNode(prev.val);
                node.next=eden;
                eden=node;
            }
            prev=prev.next;
        }
        return eden;
    }
}