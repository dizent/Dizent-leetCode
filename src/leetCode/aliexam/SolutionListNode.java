package leetCode.aliexam;

import leetCode.diffcault.reverseKGroup.ListNode;

/**
 * @Auther: 布谷
 * @Date: 2021/8/26 19:37
 * @Description:
 */
public class SolutionListNode {

    class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reserveListNode(ListNode nodeHead){
        ListNode pre = null;
        ListNode curr = nodeHead;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
