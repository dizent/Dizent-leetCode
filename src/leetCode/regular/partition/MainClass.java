package leetCode.regular.partition;

/**
 * @Auther: 布谷
 * @Date: 2021/9/1 17:04
 * @Description:
 */
/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode pre = null;
        ListNode suffix = null;
        ListNode curr = head;

        while(curr != null){
            if(curr.val < x){
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }else{
                ListNode next = curr.next;
                curr.next = suffix;
                suffix = curr;
                curr = next;
            }
        }
        if(pre != null) {
            curr = pre;
            while (curr != null) {
                if (curr.next == null) {
                    curr.next = suffix;
                    System.out.println("到了链表末尾");
                    break;
                }
                curr = curr.next;
            }
            return pre;
        }
        return suffix;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int x = Integer.parseInt(line);

            ListNode ret = new Solution().partition(head, x);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
