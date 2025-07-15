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
    boolean found;
    ListNode head;
    public void dfs(TreeNode node){
        if(node==null||found)
        return;
        if(node.val==head.val)
        find(node,head);
        dfs(node.left);
        dfs(node.right);
    }
    public void find(TreeNode tn,ListNode ln){
        if(ln.next==null){
            found=true;
            return;
        }
        int lv=ln.next.val;
        if(tn.left!=null){
            if(tn.left.val==lv)
            find(tn.left,ln.next);
        }
        if(tn.right!=null){
            if(tn.right.val==lv)
            find(tn.right,ln.next);
        }
        if(tn.left==null&&tn.right==null)
        return;
        
    }
    public boolean isSubPath(ListNode h, TreeNode root) {
        found=false;
        head=h;
        dfs(root);
        return found;
    }
}