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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head, fast = head, middlePrev = null;

        while(fast != null && fast.next != null){
            middlePrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == head && fast == head) return null;

        middlePrev.next = middlePrev.next.next;

        return head;


    }
}