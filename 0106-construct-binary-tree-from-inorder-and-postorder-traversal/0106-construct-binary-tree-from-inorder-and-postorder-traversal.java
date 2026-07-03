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


import java.util.Arrays;

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, postorder);
    }

    TreeNode build(int[] inorder, int[] postorder) {

        // Base Case
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        // Last element of postorder is the root
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // Find root in inorder
        int mid = 0;

        while (inorder[mid] != postorder[postorder.length - 1]) {
            mid++;
        }

        // Build Left Subtree
        root.left = build(
                Arrays.copyOfRange(inorder, 0, mid),
                Arrays.copyOfRange(postorder, 0, mid)
        );

        // Build Right Subtree
        root.right = build(
                Arrays.copyOfRange(inorder, mid + 1, inorder.length),
                Arrays.copyOfRange(postorder, mid, postorder.length - 1)
        );

        return root;
    }
}