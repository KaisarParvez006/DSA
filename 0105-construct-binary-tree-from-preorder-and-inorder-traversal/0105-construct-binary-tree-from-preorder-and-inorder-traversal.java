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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Start recursion
        return build(preorder, inorder);
    }
    TreeNode build(int[] preorder, int[] inorder) {
        // No elements
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        // First preorder element is root
        TreeNode root = new TreeNode(preorder[0]);
        // Find root in inorder
        int mid = 0;
        while (inorder[mid] != preorder[0]) {
            mid++;
        }
        // Build left subtree
        root.left = build(
                java.util.Arrays.copyOfRange(preorder, 1, mid + 1),
                java.util.Arrays.copyOfRange(inorder, 0, mid)
        );
        // Build right subtree
        root.right = build(
                java.util.Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                java.util.Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );
        return root;
    }
}