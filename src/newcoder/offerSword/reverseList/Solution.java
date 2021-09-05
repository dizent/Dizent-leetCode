package newcoder.offerSword.reverseList;

import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode root = new ListNode(head.val);
        ListNode next = head.next;
        ListNode reverseList = reverseList(next);
        next.next = head;
        head.next = null;
//        ListNode last = prefix;
//        while (last.next != null) {
//            last = last.next;
//        }
//        last.next = root;
        return reverseList;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(head.val);
        while(head.next != null){
            head = head.next;
            nodeStack.push(head.val);
        }
        ListNode root = new ListNode(nodeStack.pop());
        ListNode last = root;
        while(!nodeStack.isEmpty()){
            ListNode node = new ListNode(nodeStack.pop());
            last.next = node;
            last = last.next;
        }
        return root;
    }

    public ListNode reverseList3(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = null;
        while(head != null){
            //先保存访问的节点的下一个节点，保存起来
            //留着下一步访问的
            ListNode temp = head.next;
            //每次访问的原链表节点都会成为新链表的头结点，
            //其实就是把新链表挂到访问的原链表节点的
            //后面就行了
            head.next = newHead;
            //更新新链表
            newHead = head;
            //重新赋值，继续访问
            head = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode param = ListNode.arrayToListNode(arr);
        System.out.println(new Solution().reverseList(param).toString());
    }
}
