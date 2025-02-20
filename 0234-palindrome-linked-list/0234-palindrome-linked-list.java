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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head; 
        ArrayList <Integer> list = new ArrayList<>();
        while(temp != null ){
            list.add(temp.val);
            temp=temp.next;
        }

        int i=0, j=list.size()-1;
        while(i<=j){
            if(list.get(i) == list.get(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}