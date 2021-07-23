public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int idx = 0;
        ListNode currentNode = head;
        while(currentNode != null) {
            idx++;
            currentNode = currentNode.next;
        }
        if(idx == n) {
            head = head.next;
        } else {
            currentNode = head;
            for (int i = 0; i < idx - n - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        return head;
    }
}
