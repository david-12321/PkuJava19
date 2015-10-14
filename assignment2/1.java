
public class AddTwoNum {

	public static void main(String[] args) {
		ListNode l1 = null;
//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(0);
//		l1.next.next = new ListNode(0);
//		l1.next.next.next = new ListNode(1);
//		
		ListNode l2 = null;
//		ListNode l2 = new ListNode(9);
//		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(9);
//		l2.next.next.next = new ListNode(8);
//		l2.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode result = addTwoNumbers2(l1, l2);
		
		while(result != null)
		{
			System.out.print(result.val + "-->");
			result = result.next;
		}
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null)
    	{
    		return l2;
    	}
    	if(l2 == null)
    	{
    		return l1;
    	}
    	
        boolean isCarry = false;
        ListNode pre = new ListNode(0);
        ListNode resList = pre;
        ListNode cur = null;
        int sum = 0;
        
        while(l1 != null)
        {
        	cur = new ListNode(0);
            sum = 0;
        	if(isCarry)
        	{
        		sum = cur.val + 1;
        	}
        	if(l2 != null)
        	{
        		sum += l1.val + l2.val;
        		l2 = l2.next;
        	}
        	else 
        	{
        		sum += l1.val;
			}
        	
        	if(sum >= 10)
        	{
        		sum = sum - 10;
        		isCarry = true;
        	}
        	else {
        		isCarry = false;
			}
        	
        	cur.val += sum;
        	
        	l1 = l1.next;
        	pre.next = cur;
        	pre = cur;
        }
        
        while(l2 != null)
        {
        	cur = new ListNode(0);
        	sum = 0;
        	if(isCarry)
        	{
        		sum = cur.val + 1;
        	}
        	
        	sum += l2.val;
        	
        	if(sum >= 10)
        	{
        		sum = sum - 10;
        		isCarry = true;
        	}
        	else {
        		isCarry = false;
			}
        	
        	cur.val += sum;
        	
        	l2 = l2.next;
        	pre.next = cur;
        	pre = cur;        	
        }
        
        if(isCarry)
        {
        	cur = new ListNode(1);
        	pre.next = cur;
        }
        
        if(cur.val == 0)
        {
        	pre.next = null;
        }
        
        
        return resList.next;
    }
    
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if(l1 == null)
		{
			return l2;
		}
		if(l2 == null)
		{
			return l1;
		}
		
	    boolean isCarry = false;
	    ListNode current, pre = new ListNode(0);
	    ListNode result = pre;
	
	    while(l1 != null || l2 != null || isCarry)
	    {
	    	current = new ListNode(0);
		    int sum = 0;
	    	if(isCarry)
	    	{
	    		sum += 1;
	    	}
	    	if(l1 != null)
	    	{
	    		sum += l1.val;
	    		l1 = l1.next;
	    	}
	    	if(l2 != null)
	    	{
	    		sum += l2.val;
	    		l2 = l2.next;
	    	}
	    	if(sum >= 10)
	    	{
	    		sum -= 10;
	    		isCarry = true;
	    	}
	    	else {
	    		isCarry = false;
			}
	    	
	    	current.val = sum;
	    	
	    	pre.next = current;
	    	pre = current;
	    }
	    
	    return result.next;
	}
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { 
    	  val = x; 
      }
}


	
