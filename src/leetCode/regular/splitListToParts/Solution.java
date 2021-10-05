package leetCode.regular.splitListToParts;

import java.util.Arrays;

/**
 * @Auther: 布谷
 * @Date: 2021/9/22 20:57
 * @Description:
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodeArr = new ListNode[k];
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length += 1;
            curr = curr.next;
        }
        curr = head;
        int splitLength = length / k;
        int lift = length % k;
        for (int i = 0; i < k && curr != null; i++) {
            nodeArr[i] = curr;
            int currLength = 1;
            int partSize = splitLength + (lift > i ? 1 : 0);
            while (currLength < partSize) {
                currLength++;
                curr = curr.next;
            }
            ListNode after = curr.next;
            curr.next = null;
            curr = after;
        }
        return nodeArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7 ,8};
        ListNode listNode = arrToListNode(arr, 0);
        System.out.println(Arrays.toString(new Solution().splitListToParts(listNode, 5)));

    }

    public static ListNode arrToListNode(int[] arr, int index) {
        if (arr.length > index) {
            ListNode root = new ListNode(arr[index]);
            index += 1;
            root.next = arrToListNode(arr, index);
            return root;
        }
        return null;
    }
}
