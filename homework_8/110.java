public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        if(isBalanced(root.left) == false)
        	return false;
        else if(isBalanced(root.right) == false)
        	return false;
        else
        {
        	int left = height(root.left);
        	int right = height(root.right);
        	if(Math.abs(left - right) > 1)
        		return false;
        }
        return true;
    }
    
    public int height(TreeNode root)
	{
		if(root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return left > right ? (left + 1) : (right + 1);
	}