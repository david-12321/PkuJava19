//leetcode 226
public class InvertBinaryTree
{

	public static void main(String[] args)
	{
		InvertBinaryTree out = new InvertBinaryTree();
		TreeNode root = out.new TreeNode(4);
		TreeNode child1 = out.new TreeNode(2);
		TreeNode child2 = out.new TreeNode(7);
		TreeNode child3 = out.new TreeNode(1);
		TreeNode child4 = out.new TreeNode(3);
		TreeNode child5 = out.new TreeNode(6);
		TreeNode child6 = out.new TreeNode(9);
		
		root.left=child1;
		root.right=child2;
		child1.left=child3;
		child1.right=child4;
		child2.left=child5;
		child2.right=child6;

		TreeNode res = out.invertTree(root);
		System.out.println(res.right.val);
	}
	
    public TreeNode invertTree(TreeNode root) {
    	if(root == null)
    		return null;
    	TreeNode tmpNode = root.left;
    	root.left = root.right;
    	invertTree(root.left);
    	root.right = tmpNode;
    	invertTree(root.right);
    		
		return root;
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
