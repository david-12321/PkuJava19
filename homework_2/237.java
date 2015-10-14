public void deleteNode(ListNode node) {
        while(node.next != null)
        {
        	//node.val = node.next.val;
        	//node = node.next;
        	if(node.next.next == null)
        	{
        		node.val = node.next.val;
            	node.next = null;
        	}
        	else
        	{
        		node.val = node.next.val;
        		node = node.next;
        	}
        }
    }