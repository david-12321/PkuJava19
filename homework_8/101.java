public boolean isSymmetric(TreeNode root) {
        if(root == null)
        	return true;
        return judge(root.left,root.right);
    }
	
	public boolean judge(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null)
			return true;
		else if(node1 == null || node2 == null)
			return false;
		else if(node1.val != node2.val)
			return false;
		else
			return judge(node1.left,node2.right) && judge(node1.right,node2.left);
	}