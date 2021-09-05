package leetCode.diffcault.reverseKGroup;

/**
 * @Auther: 布谷
 * @Date: 2021/7/15 16:56
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

    public ListNode arrToListNode(int[] arr,int idx) {
        if(idx > arr.length - 1){
            return null;
        }
        ListNode head = new ListNode(arr[idx]);
        head.next = arrToListNode(arr,idx + 1);
        return head;
    }


    public ListNode arr2ToListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i = 1; i < arr.length; i++) {
            ListNode thisNode = new ListNode(arr[i]);
            curr.next = thisNode;
            curr = thisNode;
        }
        return head;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
