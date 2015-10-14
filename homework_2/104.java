public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if((root.left == null) && (root.right == null))
        	return 1;
        else if(root.left == null)
        {
        	return maxDepth(root.right) + 1;
        }
        else if(root.right == null)
        {
        	return maxDepth(root.left) + 1;
        }
        else
        {
        	//return (maxDepth(root.left) > maxDepth(root.right) ? (maxDepth(root.left) + 1):( maxDepth(root.right) + 1));
        	int left = maxDepth(root.left);
        	int right = maxDepth(root.right);
        	if(left > right)
        	    return left + 1;
        	else
        	    return right + 1;
        }
    }