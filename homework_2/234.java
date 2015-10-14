public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while(p != null)
        {
        	stack.push(p.val);
        	p = p.next;
        }
        p = head;
        while(p != null)
        {
        	if(p.val == stack.pop())
        		p = p.next;
        	else
        		break;
        }
        if(p == null)
        	return true;
        else
        	return false;
    }