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
    // 1->2->3->4->5->NULL
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, tmp;

        while(curr != null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
    }
    return prev;
    }
}
