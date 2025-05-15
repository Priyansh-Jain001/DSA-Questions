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

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode next = null, prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
    public void reorderList(ListNode head) {

        ListNode mid = getMid(head);

        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = head;
        ListNode right = reverseLL(rightHead);
        ListNode nextL = null, nextR = null;

        while(left != null && right != null){
            nextL =  left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL; 
            right = nextR;
        }
    }
}