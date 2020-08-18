package leetCode.regular.intToRoman;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
 * <p>
 * 示例1:
 * <p>
 * 输入:3
 * 输出: "III"
 * 示例2:
 * <p>
 * 输入:4
 * 输出: "IV"
 * 示例3:
 * <p>
 * 输入:9
 * 输出: "IX"
 * 示例4:
 * <p>
 * 输入:58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例5:
 * <p>
 * 输入:1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 思路：
     * <p>
     * 从左到右，对num进行转换
     * 当遇到4，9时，进行特殊转换，其他情况下，进行正常转换
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int partNum = num / 1000;
        while (partNum > 0) {
            sb.append("M");
            partNum--;
        }
        num %= 1000;
        if (num / 100 == 9) {
            sb.append("CM");
            num -= 900;
        } else if (num / 100 >= 5) {
            sb.append("D");
            num -= 500;
        } else if (num / 100 == 4) {
            sb.append("CD");
            num -= 400;
        }
        partNum = num / 100;
        while (partNum > 0) {
            sb.append("C");
            partNum--;
        }

        num %= 100;
        if (num / 10 == 9) {
            sb.append("XC");
            num -= 90;
        } else if (num / 10 >= 5) {
            sb.append("L");
            num -= 50;
        } else if (num / 10 == 4) {
            sb.append("XL");
            num -= 40;
        }
        partNum = num / 10;
        while (partNum > 0) {
            sb.append("X");
            partNum--;
        }
        num %= 10;
        if (num == 9) {
            sb.append("IX");
            num -= 9;
        } else if (num >= 5) {
            sb.append("V");
            num -= 5;
        } else if (num == 4) {
            sb.append("IV");
            num -= 4;
        }
        partNum = num;
        while (partNum > 0) {
            sb.append("I");
            partNum--;
        }
        return sb.toString();
    }

    /**
     * 思路：
     *
     * 与上方题解相同，对数字对应的罗马数字，从大到小进行转换
     * 初始化两个对应的数组，相同序号的数字与罗马数字相等
     * 在数组中添加了特殊规则的罗马数字，例如（4，9，40，90）
     * 在循环到对应的数字时，直接转换为两位罗马数字，不再代码里面进行特殊判断
     *
     */
    static String[] romanArr = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    static int[]    intArr   = new     int[]{1 ,  4,    5,   9,    10,  40,   50,  90,   100, 400, 500,  900, 1000};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = intArr.length - 1; i >= 0; i--) {
            while (num >= intArr[i]) {
                num -= intArr[i];
                sb.append(romanArr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 400;
        System.out.println(new Solution().intToRoman(num));
        System.out.println(new Solution().intToRoman2(num));
    }
}
