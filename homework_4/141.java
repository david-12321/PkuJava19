public boolean hasCycle(ListNode head) {
        ListNode p = head,q=head;//p每次移一次，q每次移2次
        while(p != null && q != null)
        {
        	p = p.next;
        	//q = q.next.next;
        	q = q.next;
        	if(q == null)
        	    break;
        	else
        	    q = q.next;
        	if(p == q)
        		break;
        }
        if(p == null || q == null)
        	return false;
        else
        	return true;
    }