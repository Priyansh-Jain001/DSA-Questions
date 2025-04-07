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
     public List<List<Integer>> func(TreeNode root){
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) return l;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Level marker

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            if (curr == null) {
                l.add(new ArrayList<>(list)); // Add a copy of the current level
                list.clear(); // Clear for next level

                if (!q.isEmpty()) {
                    q.add(null); // Add marker for next level
                }
            } else {
                list.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return l;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return func(root);
    }
}