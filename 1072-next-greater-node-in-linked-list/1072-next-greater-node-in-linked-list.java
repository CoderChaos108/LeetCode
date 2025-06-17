class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode current = head;
        int size = 0;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            size++;
        }
        int[] ans = new int[size];
        int i = size - 1;
        ListNode mono = null; 

        while (prev != null) {
            while (mono != null && mono.val <= prev.val) {
                mono = mono.next;
            }
            if (mono != null) {
                ans[i] = mono.val;
            }
            ListNode newNode = new ListNode(prev.val);
            newNode.next = mono;
            mono = newNode;
            i--;
            prev = prev.next;
        }
        return ans;
    }
}
