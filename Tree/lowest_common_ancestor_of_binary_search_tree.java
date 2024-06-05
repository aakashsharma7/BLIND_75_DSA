/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) {
            return null;
        }
        
        // If the current node is p or q, return the current node
        if (root == p || root == q) {
            return root;
        }
        
        // Recur for the left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        // If both leftLCA and rightLCA are non-null, it means p and q are
        // found in different subtrees, so the current node is their LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        
        // Otherwise, if one of them is non-null, return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
