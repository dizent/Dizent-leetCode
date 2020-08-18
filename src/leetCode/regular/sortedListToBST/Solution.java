package leetCode.regular.sortedListToBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 思路：个人菜鸡版
     *
     * 1 找到中间元素，必定是根节点
     * 2 将list从中间进行分割，左右两个列表
     * 3 左右两个列表分别递归
     *
     * 思路2： 题解版
     *
     * 1 定义两个快慢指针，遍历链表，快指针一次向后两个元素，满指针一次向后一个元素
     * 2 当快指针遍历到最后一个元素时，慢指针正好在链表中间
     * 3 中间元素为根元素
     * 4 将慢指针对应链表元素的后续断开，链表分为两个
     * 5 拆分后的链表前段为左子树。后段位右子树
     * 6 递归拆分后的两个链表，当链表无法拆分（剩最后一个元素）或链表为空时，结束递归
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head.val);
            head = head.next;
        }
        return listToBST(nodeList);
    }

    private TreeNode listToBST(List<Integer> nodeList) {
        if(nodeList.size() == 0 ){
            return null;
        }
        int midIndex = nodeList.size() >> 1;
        TreeNode root = new TreeNode(nodeList.get(midIndex));
        if(nodeList.size() == 1){
            return root;
        }
        root.left = listToBST(nodeList.subList(0,midIndex));
        root.right = listToBST(nodeList.subList(midIndex,nodeList.size()));

        return root;
    }

    /**
     * 如果每层分布一个节点，以下方式可行，但是不能通过
     * @param nodeValues
     * @return
     */
    //        while (leftIndex >= 0) {
//            TreeNode node = queue.remove();
//
//            if (leftIndex >= 0) {
//                int leftVal = nodeList.get(leftIndex);
//                if (leftVal > node.val) {
//                    node.right = new TreeNode(leftVal);
//                    queue.add(node.right);
//                } else {
//                    node.left = new TreeNode(leftVal);
//                    queue.add(node.left);
//                }
//                leftIndex--;
//            }
//        }
//        queue.removeAll(queue);
//        queue.add(root);
//        while (rightIndex > midIndex) {
//            TreeNode node = queue.remove();
//
//            if (rightIndex > midIndex) {
//                int rightVal = nodeList.get(rightIndex);
//                if (rightVal > node.val) {
//                    node.right = new TreeNode(rightVal);
//                    queue.add(node.right);
//                } else {
//                    node.left = new TreeNode(rightVal);
//                    queue.add(node.left);
//                }
//                rightIndex--;
//            }
//        }

    public static ListNode stringToListNode(int[] nodeValues) {
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static void main(String[] args) {
        int[] param = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println(new Solution().sortedListToBST(stringToListNode(param)));
    }
}
