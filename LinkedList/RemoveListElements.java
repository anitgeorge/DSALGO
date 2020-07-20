/*
 * Remove all elements from a linked list of integers that have value val.
 */

public class RemoveListElements{

	public removeElements(ListNode head){

		if(head == null)
			return head;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}
}
