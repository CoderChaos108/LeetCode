class Solution {
    public class ListNode{
        ListNode next=null;
        int val;
        public ListNode(int val){
        this.val=val;
        }
    }
    public int findTheWinner(int n, int k) {
        if(k==1)
        return n;
        ListNode head=new ListNode(1);
        ListNode last=head;
        for(int i=2;i<=n;i++){
            ListNode node=new ListNode(i);
            last.next=node;
            last=last.next;
        }
        last.next=head;
        ListNode current=head;
        while(current.next!=current){
            ListNode prev=null;
            for(int i=0;i<k-1;i++){
                prev=current;
                current=current.next;
            }
            current=current.next;
            prev.next=null;
            prev.next=current;
        }
        return current.val;
    }
}