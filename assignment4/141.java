/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
	    	return false;
	    	
	    ListNode i = head.next;
	    ListNode j = head.next.next;
	    
	    while(i != j){
	    	if(j == null || j.next == null || j.next.next == null)
	    		return false;
	    	i = i.next;
	    	j = j.next.next;
	    }
		return true;
    }
}