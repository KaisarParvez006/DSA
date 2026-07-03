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

    // Stores the sum
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {

        // Start inorder traversal
        inorder(root, low, high);

        // Return final sum
        return sum;
    }

    // Inorder Traversal
    void inorder(TreeNode root, int low, int high) {

        // Base Case
        if (root == null)
            return;

        // Visit Left Subtree
        inorder(root.left, low, high);

        // Check if current node value is within range
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // Visit Right Subtree
        inorder(root.right, low, high);
    }
}