
public class LeetCode_2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addNum = 0;
        ListNode head = null;
        ListNode current = null;
        while (true) {
            if (l1 == null && l2 == null)
                break;

            int l1Value = l1 != null ? l1.val : 0;
            int l2Value = l2 != null ? l2.val : 0;
            int sum = l1Value + l2Value + addNum;
            addNum = sum >= 10 ? 1 : 0;
            if (sum >= 10) {
                sum %= 10;
            }
            ListNode node = new ListNode(sum);
            if (current == null) {
                head = node;
                current = head;
            } else {
                current.next = node;
                current = node;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (addNum != 0) {
            current.next = new ListNode(addNum);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
