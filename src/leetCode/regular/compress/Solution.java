package leetCode.regular.compress;

/**
 * @Auther: 布谷
 * @Date: 2021/8/21 20:56
 * @Description:
 */
public class Solution {

    public int compress(char[] chars) {
        int size = chars.length;
        int newIndex = 0,cStart = 0;
        for(int curIndex = 0;curIndex<chars.length;curIndex ++) {
            if(curIndex == size - 1 || chars[curIndex] != chars[curIndex + 1]){
                chars[newIndex ++] = chars[curIndex];
                int num = curIndex - cStart + 1;
                if(num > 1){
                    char[] numsChar = String.valueOf(num).toCharArray();
                    for (char c : numsChar) {
                        chars[newIndex++] = c;
                    }
                }
                cStart = curIndex + 1;
            }
        }

        return newIndex;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b'};
        System.out.println(new Solution().compress(chars));
        System.out.println(chars);
    }

}
