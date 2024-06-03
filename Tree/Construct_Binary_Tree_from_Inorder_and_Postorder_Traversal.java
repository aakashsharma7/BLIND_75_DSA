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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // The last element in postorder is the root of the current subtree
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the index of the root in inorder array
        int rootIndex = inStart;
        for (; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }
        
        // Calculate the number of elements in the left subtree
        int leftSize = rootIndex - inStart;
        
        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
        
        return root;
    }
}
