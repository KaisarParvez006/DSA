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

    // Stores inorder traversal
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {

        // Perform inorder traversal
        inorder(root);

        // Check if array is strictly increasing
        for (int i = 0; i < list.size() - 1; i++) {

            // If current value is greater than or equal to next value
            // Then it is NOT a valid BST
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        // All values are in increasing order
        return true;
    }

    // Inorder Traversal
    void inorder(TreeNode root) {

        // Base Case
        if (root == null)
            return;

        // Visit Left
        inorder(root.left);

        // Store Current Node
        list.add(root.val);

        // Visit Right
        inorder(root.right);
    }
}