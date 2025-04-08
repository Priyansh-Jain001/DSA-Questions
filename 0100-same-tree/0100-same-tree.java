class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;  // both are null
        if (p == null || q == null) return false; // only one is null

        if (p.val != q.val) return false;         // values don't match

        // compare left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
