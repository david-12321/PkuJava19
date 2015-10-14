
public class PalindromeLinkedList
{

	public static void main(String[] args)
	{
		PalindromeLinkedList out =new PalindromeLinkedList();
		PalindromeLinkedList.ListNode node1 = out.new ListNode(1);
		PalindromeLinkedList.ListNode node2 = out.new ListNode(2);
//		PalindromeLinkedList.ListNode node3 = out.new ListNode(2);
//		PalindromeLinkedList.ListNode node6 = out.new ListNode(2);
//		PalindromeLinkedList.ListNode node4 = out.new ListNode(2);
//		PalindromeLinkedList.ListNode node5 = out.new ListNode(1);
		node1.next=node2;
//		node2.next=node3;
//		node3.next=node6;
//		node6.next=node4;
//		node4.next=node5;
//		node5.next=null;


		PalindromeLinkedList p = new PalindromeLinkedList();
//		p.reverse(node1);
		System.out.println(p.isPalindrome(node1));
	}
	
	public boolean isPalindrome(ListNode head) 
	{
		if(head==null||head.next==null)
			return true;
		
		ListNode fastNode=head;
		ListNode slowNode=head;
		ListNode tempNode=head;
		while(fastNode!=null&&fastNode.next!=null)
		{
			slowNode = slowNode.next;
			fastNode=fastNode.next.next;
		}
		if(fastNode!=null)
		{
			slowNode = slowNode.next;
		}
		slowNode=reverse(slowNode);

		while(slowNode!=null)
		{
			if(slowNode.val!=tempNode.val)
				return false;
			slowNode=slowNode.next;
			tempNode=tempNode.next;
		}
        return true;
    }
	
	public static ListNode reverse(ListNode node)
	{
		if(node==null || node.next==null)
			return node;
		if(node.next.next==null)
		{
			ListNode temp = node;
			node=node.next;
			node.next=temp;
			temp.next=null;
			return node;
		}
		ListNode pre = node;
		node = node.next;
		ListNode next = node.next;
		pre.next=null;
		
		while(next!=null)
		{
			node.next=pre;
			pre =node;
			node=next;
			next=next.next;
		}
		node.next = pre;

		return node;
	}
	
	public class ListNode 
	{
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	}
}
