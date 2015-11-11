public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
			return head;
        ListNode p = head;
        ListNode q = head.next;
        while(q != null)
        {
        	if(p.val == q.val)
        	{
        		p.next = q.next;
        		q = q.next;
        	}
        	else
        	{
        		p = q;
        		q = q.next;
        	}
        }
        return head;
    }