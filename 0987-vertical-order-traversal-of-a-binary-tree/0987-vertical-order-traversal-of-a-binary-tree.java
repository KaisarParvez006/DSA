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

    // Stores Node + Row + Column
    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    // Stores Row and Value for sorting later
    class Point {
        int row;
        int value;

        Point(int row, int value) {
            this.row = row;
            this.value = value;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // Final Answer
        List<List<Integer>> result = new ArrayList<>();

        // Edge Case
        if (root == null)
            return result;

        // Column -> List of (Row, Value)
        TreeMap<Integer, ArrayList<Point>> map = new TreeMap<>();

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();

        // Root starts at Row = 0, Column = 0
        q.offer(new Pair(root, 0, 0));

        // BFS Traversal
        while (!q.isEmpty()) {

            // Remove first node from queue
            Pair current = q.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            // If column doesn't exist, create it
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            // Store current node's row and value
            map.get(col).add(new Point(row, node.val));

            // Left Child
            // Row + 1
            // Column - 1
            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            // Right Child
            // Row + 1
            // Column + 1
            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        // Traverse columns from left to right
        for (ArrayList<Point> list : map.values()) {

            // Sort:
            // 1. Smaller Row first
            // 2. If same Row, Smaller Value first
            Collections.sort(list, (a, b) -> {

                if (a.row == b.row)
                    return a.value - b.value;

                return a.row - b.row;
            });

            // Stores one vertical column
            List<Integer> column = new ArrayList<>();

            // Add only node values
            for (Point p : list) {
                column.add(p.value);
            }

            // Add this column to answer
            result.add(column);
        }

        return result;
    }
}