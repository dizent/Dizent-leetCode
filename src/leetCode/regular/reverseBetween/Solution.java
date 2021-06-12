package leetCode.regular.reverseBetween;

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reserver(head, 1, left, right);
    }

    public ListNode reserver(ListNode head, int occu, int left, int right) {
        if (head == null) {
            return head;
        }
        if (occu < left) {
            ListNode reverseHead = reserver(head.next, occu + 1, left, right);
            head.next = reverseHead;
            return reverseHead;
        }

        if (occu < right) {
            ListNode reverseHead = reserver(head.next, occu + 1, left, right);
            head.next = null;
            return reverseHead;
        }
        return head;
    }

    public static ListNode arrToListNode(int[] arr, int index) {
        if (arr.length > index) {
            ListNode root = new ListNode(arr[index]);
            index += 1;
            root.next = arrToListNode(arr,index);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(new Solution().reverseBetween(arrToListNode(arr,0),3,4));
    }

}
