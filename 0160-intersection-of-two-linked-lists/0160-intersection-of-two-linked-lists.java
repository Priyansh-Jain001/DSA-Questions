/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        /* the below code will work better when you have to find the intesected value too
        int lengthA=0, lengthB = 0;

        ListNode tempA = headA;
        while(tempA != null){
            lengthA += 1;
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while(tempB != null){
            lengthB += 1;
            tempB = tempB.next;
        }

        int diff = Math.abs(lengthA-lengthB);
        tempA = headA;
        tempB = headB;
        if(lengthA > lengthB){
            for(int i=0; i<diff; i++){
                tempA = tempA.next;
            }
        }else if(lengthA < lengthB){
            for(int i=0; i<diff; i++){
                tempB = tempB.next;
            }
        }

        while(tempA != null && tempB != null){
            if(tempA.next == tempB.next){
                return tempA.next;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }

         return null; */

        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA;

        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }

            set.add(temp);
            temp = temp.next;
        }

        return null;
         
    }
}