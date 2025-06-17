class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode current=head;
        int size=0;
        ListNode prev=null;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
            size++;
        }
        int[] ans=new int[size];
        int i=size-1;
        ArrayList<Integer> monoStack=new ArrayList<>();
        while(prev!=null){
            while(!monoStack.isEmpty()&&monoStack.get(monoStack.size()-1)<=prev.val){
                monoStack.remove(monoStack.size()-1);
            }
            if(!monoStack.isEmpty()){
                ans[i]=monoStack.get(monoStack.size()-1);
            }
            monoStack.add(prev.val);
            i--;
            prev=prev.next;
        }
        return ans;
    }
}
