/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class GetRandomNode{

	ListNode head;
	Random random;

	public GetRandomNode(ListNode head){
	
		this.head = head;
		random = new Random();
	}

	public int getRandom(){

		ListNode node = head;
		int result = node.val;
		for(int i = 1; node.next != nul; i++){

			node = node.next;
			if(random.nextInt(i + 1) == i)
				result = node.val;
		}
		return result;
	}
}
