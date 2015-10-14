
public class DeleteNode
{

	
//	ListNode node1 = new ListNode(1);
//	ListNode node2 = new ListNode(2);
//	ListNode node3 = new ListNode(23);
//	ListNode node4 = new ListNode(4);
	
	
	public static void main(String[] args)
	{
		DeleteNode out =new DeleteNode();
		DeleteNode.ListNode node1 = out.new ListNode(1);
		DeleteNode.ListNode node2 = out.new ListNode(2);
		DeleteNode.ListNode node3 = out.new ListNode(3);
		DeleteNode.ListNode node4 = out.new ListNode(4);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=null;
		out.deleteNode(node3);
		
		System.out.print(node2.next.val);
	}
	
	public void deleteNode(ListNode node) {
        if(node!=null)
        {
        	node.val = node.next.val;
        	node.next=node.next.next;
        }
    }


	public class ListNode 
	{
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
}

