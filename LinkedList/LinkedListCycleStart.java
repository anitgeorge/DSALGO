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
public class LinkedListCycleStart {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null)
            return null;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null && fast != slow){
            
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow? findStart(head, slow) : null;
    }
    
    private ListNode findStart(ListNode head, ListNode slow){
        
        ListNode curr = slow;
        int count = 0;
        do{
            ++count;
            curr = curr.next;
        }while(curr != slow);
        ListNode p1 = head, p2 = head;
        while(count > 0){
            
            p1 = p1.next;
            --count;
        }
        
        while(p1 != p2){
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }
}
