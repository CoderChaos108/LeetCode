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
    public void sort(ListNode head,ListNode tail,int size){
        if(size==1){
            return;
        }
        if(size==2){
            if(head.val>tail.val){
                int temp=head.val;
                head.val=tail.val;
                tail.val=temp;
            }
            return;
        }
        ListNode mid=head;
        int m=size/2;
        for(int i=0;i<m-1;i++){
            mid=mid.next;
        }
        ListNode midNext=mid.next;
        sort(head,mid,m);
        sort(midNext,tail,size-m);
        int[] a=new int[size];
        ListNode p=head;
        ListNode q=midNext;
        for(int i=0;i<size;i++){
            if(p==midNext){
                a[i]=q.val;
                q=q.next;
            }
            else if(q==tail.next){
                a[i]=p.val;
                p=p.next;
            }
            else{
                if(p.val<=q.val){
                    a[i]=p.val;
                    p=p.next;
                }
                else{
                    a[i]=q.val;
                    q=q.next;
                }
            }
        }
        for(int i=0;i<size;i++){
            head.val=a[i];
            head=head.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head==null)
        return null;
        ListNode current=head;
        int size=0;
        while(current.next!=null){
            size++;
            current=current.next;
        }
        sort(head,current,size+1);
        return head;
    }
}