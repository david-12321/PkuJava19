public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if(root == null)
        	return answer;
        else
        {
        	Stack<TreeNode> s = new Stack<TreeNode>();
        	TreeNode p = root;
        	while(p != null)
        	{
        		s.push(p);
        		p = p.left;
        	}
        	while(!s.isEmpty())
        	{
        		answer.add(s.peek().val);
        		p = s.pop().right;
        		while(p != null)
        		{
        			s.push(p);
        			p = p.left;
        		}
        		
        	}
        }
        return answer;
    }