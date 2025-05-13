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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp=head;
        ListNode[] a=new ListNode[k];
        int idx=0;
        int x=0;
        ListNode current=head;
        while(current!=null){
            x++;
            current=current.next;
        }
        current=head;
        if(k>=x){
            for(int i=0;i<k;i++){
                if(current!=null)
                a[i]=new ListNode(current.val);
                else
                a[i]=current;
                if(current!=null)
                current=current.next;
            }
        }
        else{
            for(int i=0;i<x%k;i++){
                current=head;
                for(int j=0;j<x/k;j++){
                    current=current.next;
                }
                temp=current.next;
                current.next=null;
                a[idx]=head;
                idx++;
                head=temp;
            }
            for(int i=0;i<k-x%k;i++){
                current=head;
                for(int j=0;j<x/k-1;j++){
                    current=current.next;
                }
                temp=current.next;
                current.next=null;
                a[idx]=head;
                idx++;
                head=temp;
            }
            }
                    return a;
        }
}