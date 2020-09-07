package nowcoder.offerSword.reverseList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" +
                "\"val\":" + val +
                "\"next\":" + next +
                '}';
    }

    public static ListNode arrayToListNode(int[] nodeValues) {
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
