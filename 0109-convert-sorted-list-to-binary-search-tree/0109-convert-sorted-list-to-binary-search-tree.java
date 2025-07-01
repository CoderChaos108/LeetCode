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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode build(ListNode head){
        if(head==null)
        return null;
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode current=head;
        int size=0;
        while(current!=null){
            size++;
            current=current.next;
        }
        current=head;
        ListNode mid;
        for(int i=0;i<size/2-1;i++){
            current=current.next;
        }
        mid=current.next;
        current.next=null;
        TreeNode node=new TreeNode(mid.val);
        node.left=build(head);
        node.right=build(mid.next);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return build(head);
    }
}