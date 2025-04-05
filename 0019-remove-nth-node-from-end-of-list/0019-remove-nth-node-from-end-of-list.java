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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length += 1;
            temp=temp.next;
        }

        int nodeToBeDeleted = length-n;  // i-th node that is to be deleted

        if(nodeToBeDeleted == 0){
            if(head.next != null){
                head = head.next;
                return head;
            }else{
               return head=null; 
            }
        } 

        temp = head;
        for(int i=0; i<nodeToBeDeleted-1 && temp != null; i++){
            temp = temp.next;
        }

        if(temp == null || temp.next == null){
            return null;
        }


        temp.next = temp.next.next;
        return head;
    }
}