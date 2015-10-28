import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class MinDepth
{

	public static void main(String[] args)
	{
		MinDepth out =new MinDepth();
		MinDepth.TreeNode root = out.new TreeNode(1);
		MinDepth.TreeNode child1 = out.new TreeNode(2);
		MinDepth.TreeNode child2 = out.new TreeNode(3);
		MinDepth.TreeNode child3 = out.new TreeNode(4);
		MinDepth.TreeNode child4 = out.new TreeNode(5);
		MinDepth.TreeNode child5 = out.new TreeNode(6);
		
		root.left=child1;
		root.right=child2;
//		child1.left=child3;
//		child1.right=child4;
		child2.left=child5;
		System.out.println(new MinDepth().minDepth(root));
	}

	public int minDepth(TreeNode root)
	{
		if(root==null) return -1;
		int parentCount=0;
		int childCount=0;
		int depth=0;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		depth++;
		parentCount++;
		
		//层次遍历
		while(!queue.isEmpty())
		{
			TreeNode tempNode = queue.poll();
			parentCount--;

			if(tempNode.left==null&&tempNode.right==null)
			{
				 return depth;
			}
			if(tempNode.left!=null)
			{
				queue.offer(tempNode.left);
				childCount++;
			}
				
			if(tempNode.right!=null)
			{
				queue.offer(tempNode.right);
				childCount++;
			}
			if(parentCount==0)
			{
				depth++;
				parentCount=childCount;
				childCount=0;
			}
		}
		
		return -1;
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
