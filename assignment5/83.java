
public class RemoveDuplicates
{

	public static void main(String[] args)
	{
		RemoveDuplicates out = new RemoveDuplicates();
		ListNode head = out.new ListNode(0);
		ListNode node1 = out.new ListNode(1);
		ListNode node11 = out.new ListNode(1);
		ListNode node2 = out.new ListNode(2);
		ListNode node22 = out.new ListNode(2);
		ListNode node3 = out.new ListNode(3);
		ListNode node4 = out.new ListNode(4);
		ListNode node44 = out.new ListNode(4);
		ListNode node444 = out.new ListNode(4);
		
		head.next=node1;
		node1.next=node11;
		node11.next=node2;
		node2.next=node22;
		node22.next=node3;
		node3.next=node4;
		node4.next=node44;
		node44.next=node444;
		
		head = out.deleteDuplicates(head);
		
		while(head!=null)
		{
			System.out.print(head.val);
			head = head.next;
		}
	}

    public ListNode deleteDuplicates(ListNode head) 
    {
    	if(head==null)
    		return null;
    	
    	int preVal=head.val;
    	ListNode preNode =head;
    	ListNode node = preNode.next;
    	
    	while(node!=null)
    	{
    		if(node.val==preVal)
			{
    			preNode.next = node.next;
			}
    		else 
    		{
    			preVal=node.val;
        		preNode = node;
			}
    		node=node.next;
    	}
    	
        return head;
    }
    
	public class ListNode 
	{
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	}
}
