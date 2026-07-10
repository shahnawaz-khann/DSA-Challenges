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
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while(curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        ListNode curr2 = headB;
        while(curr2 != null) {
            if(set.contains(curr2)) {
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;
    }
}