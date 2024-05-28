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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // If the node is null, the depth is 0
        } else {
            int leftDepth = maxDepth(root.left); // Recursively find the depth of the left subtree
            int rightDepth = maxDepth(root.right); // Recursively find the depth of the right subtree
            return Math.max(leftDepth, rightDepth) + 1; // Return the greater of the two depths plus one for the current node
        }
    }
}
