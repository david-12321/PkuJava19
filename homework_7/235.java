public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = p.val > q.val ? q.val:p.val;
        int big = p.val < q.val ? q.val:p.val;
        while(root != null)
        {
        	if(root.val > small && root.val > big)
        		root = root.left;
        	else if(root.val < small && root.val < big)
        		root = root.right;
        	else
        		return root;
        }
        return null;
    }