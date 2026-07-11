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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftt = dummy;
        ListNode curr = head;

        for(int i=1; i<left; i++) {
            leftt = leftt.next;
            curr = curr.next;
        }
        ListNode rightt = curr;

        ListNode prev = null;
        for(int i=1; i<=right-left+1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        leftt.next = prev;
        rightt.next = curr;

        return dummy.next;
    }
}