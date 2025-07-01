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
    List<Integer> list;
    public TreeNode build(int west,int east){
        if(west>east)
        return null;
        int n=west+(east-west)/2;
        TreeNode node=new TreeNode(list.get(n));
        node.left=build(west,n-1);
        node.right=build(n+1,east);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        return build(0,list.size()-1);
    }
}