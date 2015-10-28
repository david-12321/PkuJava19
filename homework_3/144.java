public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if(root == null)
        	return answer;
        else
        {
        	Stack<TreeNode> s = new Stack<TreeNode>();
        	s.push(root);
        	while(!s.isEmpty())
        	{
        		answer.add(s.peek().val);
        		TreeNode p = s.pop();
        		//s.pop();
        		if(p.right != null)
        		{
        			s.push(p.right);
        		}
        		if(p.left != null)
        		{
        			s.push(p.left);
        		}
        	}
        }
        return answer;
    }