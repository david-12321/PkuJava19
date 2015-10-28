public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if(root == null)
        	return answer;
        else
        {
        	Stack<TreeNode> s = new Stack<TreeNode>();
        	TreeNode p = root;
        	TreeNode pre = null;
        	while(p != null)
        	{
        		s.push(p);
        		p = p.left;
        	}
        	while(!s.isEmpty())
        	{
        		while(p != null)
        		{
        			s.push(p);
        			p = p.left;
        		}
        		if(s.peek().right == null || s.peek().right == pre)
        		{
        			//pre = s.peek();
        			pre = s.pop();
        			answer.add(pre.val);
        			p = null;
        		}
        		else
        			//p = p.right;
        			p = s.peek().right;
        	}
        }
        return answer;
    }