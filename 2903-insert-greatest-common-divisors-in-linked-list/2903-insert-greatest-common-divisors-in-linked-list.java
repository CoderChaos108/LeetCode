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
    HashMap<List<Integer>,Integer> hm=new HashMap<>();
    public int gcd(int x,int y){
        int min=Math.min(x,y);
        int max=x*y/min;
        List<Integer> list=Arrays.asList(min,max);
        if(hm.containsKey(list))
        return hm.get(list);
        for(int i=min;i>1;i--){
            if(min%i==0&&max%i==0){
                hm.put(list,i);
                return i;
            }
        }
        return 1;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev=head;
        ListNode succ=head.next;
        while(prev!=null&&succ!=null){
            prev.next=new ListNode(gcd(prev.val,succ.val));
            prev.next.next=succ;
            prev=succ;
            succ=succ.next;
        }
         return head;
    }
}