class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast !=null && fast.next != null && fast != slow){

      fast == fast.next.next;
      slow = slow.next;
    }

    return fast == slow;
  }
}  
