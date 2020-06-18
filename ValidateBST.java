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
    public boolean isValidBST(TreeNode root) {
       
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    public boolean helper(TreeNode node, Long lower, Long upper) {
        if(node == null) return true;
        
        long val = node.val;
        
        if(val <= lower || val >= upper) return false;
        
        return(!helper(node.left, lower, val) || !helper(node.right, val, upper)) ? false : true;

    }
}