
public class LinkedListCycle
{

	public static void main(String[] args)
	{
		LinkedListCycle out =new LinkedListCycle();
		LinkedListCycle.ListNode node1 = out.new ListNode(1);
		LinkedListCycle.ListNode node2 = out.new ListNode(2);
		LinkedListCycle.ListNode node3 = out.new ListNode(3);
		LinkedListCycle.ListNode node4 = out.new ListNode(4);
		LinkedListCycle.ListNode node5 = out.new ListNode(5);
		LinkedListCycle.ListNode node6 = out.new ListNode(6);
		LinkedListCycle.ListNode node7 = out.new ListNode(7);
		LinkedListCycle.ListNode node8 = out.new ListNode(8);
		LinkedListCycle.ListNode node9 = out.new ListNode(9);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		node8.next=node9;
		//node9.next=node4;
		
		System.out.println(new LinkedListCycle().hasCycle(node1));
	}
	
    public boolean hasCycle(ListNode head) 
    {
        ListNode next1=head;
        ListNode next2=head;
        
        while(next2!=null&&next2.next!=null)
        {
        	next1=next1.next;
        	next2=next2.next.next;
        	
        	if(next1==next2)
        		return true;
        }
        
        return false;
    }

	public class ListNode 
	{
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	}
}
