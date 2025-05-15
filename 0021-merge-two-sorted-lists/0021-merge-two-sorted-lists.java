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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1, null);

        ListNode dummy = dummyNode;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                dummy.next = temp1;
                temp1 = temp1.next;
                dummy = dummy.next;
            }else{
                dummy.next = temp2;
                temp2 = temp2.next;
                dummy = dummy.next;
            }
        }

        while(temp1 != null){
            dummy.next = temp1;
            temp1 = temp1.next;
            dummy = dummy.next;
        }

        while(temp2 != null){
            dummy.next = temp2;
            temp2 = temp2.next;
            dummy = dummy.next;
        }
        
        return dummyNode.next;
    }
}