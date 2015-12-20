
//leetcode 101
public class SymmetricTree
{

	public static void main(String[] args)
	{
		SymmetricTree out =new SymmetricTree();
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
		child2.left=child5;
		child2.right=child6;
		
		System.out.println(out.isSymmetric(root));
	}

    public boolean isSymmetric(TreeNode root) {
    	if(root==null)
    		return true;
    	return isSymmetric2(root.left, root.right);
    }
    
    public boolean isSymmetric2(TreeNode left,TreeNode right){
    	if(left==null&&right==null)
    		return true;
    	if(left==null||right==null)
    		return false;
    	if(left.val!=right.val)
    		return false;
    	return isSymmetric2(left.left, right.right)&&isSymmetric2(left.right, right.left);
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
