package leetCode.common;

public class ListNode {

    int val;
    leetCode.regular.removeNthFromEnd.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, leetCode.regular.removeNthFromEnd.ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }


}
