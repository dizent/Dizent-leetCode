package newcoder.QueueOfStack;

import java.util.Stack;

/**
 * @Auther: 布谷
 * @Date: 2021/8/27 22:09
 * @Description:
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(node);
            stack2.push(node);
        }

    }

    public int pop() {
        return 0;
    }
}
