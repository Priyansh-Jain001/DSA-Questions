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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        
        ListNode odd= head, even=head.next,  evenStart = even;
        
        while(odd != null && even != null && odd.next != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd =  odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return head;

    }
}