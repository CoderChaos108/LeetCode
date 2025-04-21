class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1=list1;
        ListNode l2=list2;
         ListNode eden=null;
        
        if(list1==null&&list2==null)
        return null;
       
        if(list1==null){
            return l2;
        }
        else if(list2==null){
            return l1;
        }
        else{
        eden=new ListNode(Math.min(list1.val,list2.val));
        if(list1.val>list2.val)
        l2=l2.next;
        else
        l1=l1.next;
        }
        ListNode current=eden;
        while(l1!=null||l2!=null){
            if(l1==null){
            current.next=new ListNode(l2.val);
            l2=l2.next;
            }
            else if(l2==null){
            current.next=new ListNode (l1.val);
            l1=l1.next;
            }
            else{
                
                current.next=new ListNode(Math.min(l1.val,l2.val));
                if(l1.val<l2.val)
                l1=l1.next;
                else
                l2=l2.next;
            }
            current=current.next;
        }

        return eden;
    }
}