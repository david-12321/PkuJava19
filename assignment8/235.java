/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
        while(root.val < Math.min(p.val, q.val) || root.val > Math.max(p.val, q.val))
        {
            if(root.val < Math.min(p.val, q.val))
            {
                root = root.right;
            }
            if(root.val > Math.max(p.val, q.val))
            {
                root = root.left;
            }
        }
        return root;
    }
}