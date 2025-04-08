class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // update diameter at this node
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
