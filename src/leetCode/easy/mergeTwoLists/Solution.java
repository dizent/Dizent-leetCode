package leetCode.easy.mergeTwoLists;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * Related Topics 链表
 */
public class Solution {

    /**
     * 思路：
     *
     * 1 判断链表是否有空值，如果都为空：返回null 其中一个为空：返回另一个链表
     * 2 如果都不为空：
     *  + 将链表第一个元素进行大小比较，小的元素，作为第一个元素
     *  + 将头元素较小的节点取出
     *  + 将去除头结点的链表和另一个链表进行大小递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
        int[] arr1 = new int[]{1,2,4};
        int[] arr2 = new int[]{1,3,4};
        ListNode l1 = arrToListNode(arr1,0);
        ListNode l2 = arrToListNode(arr2,0);
        System.out.println(new Solution().mergeTwoLists(l1,l2).toString());
    }
}
