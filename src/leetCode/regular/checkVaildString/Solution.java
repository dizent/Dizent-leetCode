package leetCode.regular.checkVaildString;

import java.util.Stack;

/**
 * @Auther: 布谷
 * @Date: 2021/9/12 11:46
 * @Description:
 */
public class Solution {

    /**
     * 定义两个stack，存储左括号和星号的index
     * 当出现右括号时，弹出左括号或者星号
     * 如果没有对应的左括号或者星号与其对应，则返回false
     * 处理完毕所有的右括号，将左括号和星号配对，将星号看作右括号，判断星号的index是否在左括号的后面
     * 如果星号在左括号之前，返回false
     * 处理完毕所有的可以配对的左括号和星号
     * 如果左括号没有匹配完，返回false
     * 如果星号没有匹配完，可以将其看作空字符串
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack();
        Stack<Integer> aStarStack = new Stack();
        char[] sChars = s.toCharArray();
        for(int i = 0,n = sChars.length;i < n ;i ++){
            char c = sChars[i];
            if(c == '('){
                leftStack.push(i);
            }
            if(c == '*'){
                aStarStack.push(i);
            }
            if(c == ')'){
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else if(!aStarStack.isEmpty()){
                    aStarStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!leftStack.empty() && !aStarStack.empty()){
            int left = leftStack.peek();
            int star = aStarStack.peek();
            if(left < star){
                leftStack.pop();
                aStarStack.pop();
            }else{
                return false;
            }
        }
        return leftStack.empty();
    }

    /**
     * 解法II：
     * 定义左右括号变量，初始化为 0 ；
     * 遍历char[] 并判断符号类型
     *
     * 当前为
     *      (: l++,r++ 「左括号可以在前面，表示后面可以接左括号，可以接右括号的数量 + 1」
     *      ): l--,r-- 「右括号必须在后面，表示用掉了一个左括号，右括号后续的数量 - 1」
     *      *: l--,r++ 「星号可以是左，也可以是右，表示后面的左括号 - 1，或者后面能接的右括号 + 1，或者抵消」
     * 判断当前 l 是否小于 0 ，如果是，则将其置为 0；
     * 如果出现 l > r。则返回 false；只有出现左括号的时候，l ++，r ++，所以 l > r 的情况只有 右括号在前没有被匹配，因此返回false
     * @param s
     * @return
     */
    public boolean checkVaildString2(String s){
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++; r++;
            } else if (c == ')') {
                l--; r--;
            } else {
                l--; r++;
            }
            l = Math.max(l, 0);
            if (l > r) {return false;}
        }
        return l == 0;
    }

    public static void main(String[] args) {
        String str = "(((";
        System.out.println(new Solution().checkValidString(str));
        System.out.println(new Solution().checkVaildString2(str));
    }

}
