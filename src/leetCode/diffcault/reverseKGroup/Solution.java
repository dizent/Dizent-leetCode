package leetCode.diffcault.reverseKGroup;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 布谷
 * @Date: 2021/7/15 16:58
 * @Description:
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        return head;
    }

    public ListNode reserveListNode(ListNode kNode){
        ListNode pre = null;
        ListNode curr = kNode;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head2 = new ListNode().arr2ToListNode(arr);
        System.out.println(head2);
        System.out.println(new Solution().reserveListNode(head2));
    }
}
