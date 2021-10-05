package leetCode.regular.splitListToParts;

/**
 * @Auther: 布谷
 * @Date: 2021/9/22 20:58
 * @Description:
 */
public class ListNode {
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

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
