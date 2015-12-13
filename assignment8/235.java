//leetcode 235
public class LowestCommonAncestorOfBST
{

	public static void main(String[] args)
	{		
		LowestCommonAncestorOfBST out = new LowestCommonAncestorOfBST();
//		TreeNode root = out.new TreeNode(6);
//		TreeNode child1 = out.new TreeNode(2);
//		TreeNode child2 = out.new TreeNode(8);
////		TreeNode child3 = out.new TreeNode(0);
////		TreeNode child4 = out.new TreeNode(4);
////		TreeNode child5 = out.new TreeNode(7);
////		TreeNode child6 = out.new TreeNode(9);
////		TreeNode child7 = out.new TreeNode(3);
////		TreeNode child8 = out.new TreeNode(5);
		
//		root.left=child1;
//		root.right=child2;
//		child1.left=child3;
//		child1.right=child4;
//		child2.left=child5;
//		child2.right=child6;
//		child4.left=child7;
//		child4.right=child8;
		
		
		TreeNode root = out.new TreeNode(2);
		TreeNode child1 = out.new TreeNode(1);
		TreeNode child2 = out.new TreeNode(3);
		root.left=child1;
		root.right=child2;
		System.out.println(out.lowestCommonAncestor(root, child1, child2).val);
	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null)
    		return null;
    	if(p==null)
    		return q;
    	if(q==null)
    		return p;
    	if(p.val>q.val){
    		TreeNode temp = p;
    		p=q;
    		q=temp;
    	}
    	if(p.val==root.val||q.val==root.val||(p.val<root.val&&q.val>root.val))
    		return root;
    	else if(p.val<root.val&&q.val<root.val)
    		return lowestCommonAncestor(root.left,p,q);
    	else{
    		return lowestCommonAncestor(root.right,p,q);
    	}
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
