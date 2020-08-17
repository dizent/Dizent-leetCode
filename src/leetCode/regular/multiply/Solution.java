package leetCode.regular.multiply;

public class Solution {

    /**
     * 题解思路：
     *
     * 1. 将字符串转换为char数组
     * 2. 因为两数相乘，结果的位数必然不会大于两数字位数之和（例如 99 * 99 = 9801 [两个最大的两位数相乘，结果位数为 4 ]）
     * 3. 定义一个长度为 两字符串长度之和为数组，用于存储结果
     * 4. 倒序遍历 num1 的数组，嵌套循环与 num2 的各个位数上的 数字相乘。（此处做了 char 与 int 的 ascii 计算）
     * 5. 各位置计算的结果，从后向前存入，在 addNum 方法中，加入进位机制，使用递归进位，直至无需进位。
     * 6. 后续遍历 num1 时，存入结果时，对应具体的位置，插入位置为 i + j + 1，向前
     * 7. 将结果int[]转换为字符串，循环遍历，将前部的0去掉，如果结果为空，则返回字符串'0'
     *
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int num1Size = num1.length();
        int num2Size = num2.length();
        int[] resultChar = new int[num1Size + num2Size];
        for (int i = num1Size - 1; i >= 0; i--) {
            int numI = num1Char[i] - 48;
//            int[] mutiplyChar = new int[num2Size + 1];
            for (int j = num2Size - 1; j >= 0; j--) {
                int numII = num2Char[j] - 48;
                int muti = numI * numII;
//                mutiplyChar[j + 1] += muti % 10;
//                if (mutiplyChar[j + 1] > 9) {
//                    int num = mutiplyChar[j + 1];
//                    mutiplyChar[j + 1] = num % 10;
//                    mutiplyChar[j] += num / 10;
//                }
//                mutiplyChar = addNum(mutiplyChar,j+1,muti);
                resultChar = addNum(resultChar, j + 1 + i,muti);
//                resultChar[num1Size + j + 1 - num1Size + i] += muti % 10;
//                if (resultChar[num1Size + j + 1 - num1Size + i] > 9) {
//                    resultChar[num1Size + j + 1 - num1Size + i] %= 10;
//                    resultChar[num1Size + j - num1Size + i] += 1;
//                }
//                if (muti > 9) {
//                    mutiplyChar[j] += muti / 10;
//                    resultChar[num1Size + j - num1Size + i] += muti / 10;
//                    if (resultChar[num1Size + j - num1Size + i] > 9) {
////                    int addNum = resultChar[num1Size + j + 1 - num1Size + i ] / 10;
//                        resultChar[num1Size + j - num1Size + i] %= 10;
//                        resultChar[num1Size + j - num1Size + i - 1] += 1;
//                    }
//                }
            }
//            result += mutiply *  (long) Math.pow(10, num1Size - i - 1);
//            System.out.println("第 " + i + "位:" + numI + " 乘积：" + JSONObject.toJSONString(mutiplyChar));
//            System.out.println("第 " + i + "位:" + numI + " 求和：" + JSONObject.toJSONString(resultChar));
        }
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < resultChar.length; i++) {
            if (resultChar[i] == 0 && "".equals(sb.toString())) {
                continue;
            }
            sb.append(resultChar[i]);
        }
        if ("".equals(sb.toString())) {
            return "0";
        }
        return sb.toString();
    }

    private int[] addNum(int[] arr,int index,int addNum){
        arr[index] += addNum;
        if(arr[index] > 9){
            int newAdd = arr[index] / 10;
            arr[index] %= 10;
            return addNum(arr,index - 1,newAdd);
        }
        return arr;
    }

    public static void main(String[] args) {
        String num1 = "89";
        String num2 = "987654321";
        System.out.println(new Solution().multiply(num1, num2));
    }
}
