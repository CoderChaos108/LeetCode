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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        ListNode currenta=l1;
        ListNode currentb=l2;
        while(currenta!=null){
            a.add(currenta.val);
            currenta=currenta.next;
        }
        while(currentb!=null){
            b.add(currentb.val);
            currentb=currentb.next;
        }
        int c=0;
        ArrayList<Integer> s=new ArrayList<Integer>();
        int p=0;
        int q=0;
        for(int i=0;i<Math.max(a.size(),b.size());i++){
            if(i>a.size()-1)
            p=0;
            else
            p=a.get(a.size()-1-i);
            if(i>b.size()-1)
            q=0;
            else
            q=b.get(b.size()-1-i);
            s.add(0,(p+q+c)%10);
            c=(p+q+c)/10;
            if(i==Math.max(a.size(),b.size())-1&&c!=0)
            s.add(0,c);
        }
        ListNode head=new ListNode(s.get(0));
        ListNode current=head;
        for(int i=1;i<s.size();i++){
            current.next=new ListNode(s.get(i));
            current=current.next;
        }
        return head;
    }
}