package leetCode.regular.getPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合[1,2,3,…,n]，其所有元素共有n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 *
 * 说明：
 *
 * 给定 n的范围是 [1, 9]。
 * 给定 k的范围是[1, n!]。
 * 示例1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> nLine = new ArrayList<>(n);
        for(int i = 1;i <= n;i++){
            nLine.add(i);
        }
        StringBuffer sb = new StringBuffer();
        while (!nLine.isEmpty()) {
            int lessNFac = factorial(n - 1);
            int index ;
//            if(k == lessNFac){
//                index = (k / lessNFac) - 1;
//                sb.append(nLine.get(index));
//                nLine.remove(index);
//                for(int i = nLine.size() - 1;i >= 0;i--){
//                    sb.append(nLine.get(i));
//                    nLine.remove(i);
//                }
//                break;
//            }else {
                int kMore = k % lessNFac;
                if (kMore == 0) {
                    if (k == 0) {
                        index = 0;
                    } else {
                        index = (k / lessNFac) - 1;
                        k = lessNFac;
                    }
                    sb.append(nLine.get(index));
                } else {
                    index = k / lessNFac;
                    sb.append(nLine.get(index));
                    k = kMore;
                }

            nLine.remove(index);
            n--;
        }
        return sb.toString();
    }

    private int factorial(int n){
        int result = 1;
        for(int i = 1;i<=n;i++){
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 4;
        System.out.println(new Solution().getPermutation(n,k));
    }
}
