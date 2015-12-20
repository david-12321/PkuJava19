
//leetcode 110
public class BalancedBinaryTree
{

	public static void main(String[] args)
	{
		BalancedBinaryTree out =new BalancedBinaryTree();
		TreeNode root = out.new TreeNode(0);
		TreeNode child1 = out.new TreeNode(1);
		TreeNode child2 = out.new TreeNode(1);
		TreeNode child3 = out.new TreeNode(2);
		TreeNode child4 = out.new TreeNode(3);
		TreeNode child5 = out.new TreeNode(3);
		TreeNode child6 = out.new TreeNode(2);
		
		root.left=child1;
		root.right=child2;
		child1.left=child3;
		child1.right=child4;
		child3.left=child5;
		child5.left=child6;
		
		System.out.println(out.isBalanced(root));
	}
	
    public boolean isBalanced(TreeNode root) {
    	if(root==null)
    		return true;
    	return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int maxDepth(TreeNode root){
    	if(root==null)
        	return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}
}
