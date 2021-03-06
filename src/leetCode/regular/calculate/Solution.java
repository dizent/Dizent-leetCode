package leetCode.regular.calculate;

import java.util.ArrayDeque;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class Solution {


    public int calculate(String s) {
        char sign = '+';
        ArrayDeque<Integer> numsDeque = new ArrayDeque<>();
        int num = 0;
        int result = 0;
        for(int i = 0;i< s.length();i++){
            char c = s.charAt(i);
            if(c >= '0'){
                num = num * 10 - '0' + c;
            }
            if((c < '0' && c != ' ' )|| i == s.length() - 1){
                switch(sign){
                    case '+':
                        numsDeque.push(num);
                        break;
                    case '-':
                        numsDeque.push(-num);
                        break;
                    case '*':
                        numsDeque.push(numsDeque.pop()*num);
                        break;
                    case '/':
                        numsDeque.push(numsDeque.pop()/num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        while(!numsDeque.isEmpty()){
            result += numsDeque.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(new Solution().calculate(s));
    }
}
