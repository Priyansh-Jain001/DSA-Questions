class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        int size = 1;

        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        k = k % size;
        if (k == 0) return head;

        temp = head;
        for (int i = 0; i < size - k - 1; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        ListNode tail = newHead;
        while (tail.next != null) tail = tail.next;

        tail.next = head;

        return newHead;
    }
}
