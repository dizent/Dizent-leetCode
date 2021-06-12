package leetCode.regular.jianshenzi;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public int cuttingRope(int n) {
        int max = 1;
        for(int i = 2 ;i < n ;i++) {
            int product = cuttingRope(n, i);
            max = Math.max(product, max);
        }
        return max;
    }


    private int cuttingRope(int n,int num){
        int avg = n / num;
        int residue = n % num;
        int product = 1;
        for(int i = 0 ;i < num;i++){
            if(residue > 0) {
                product *= avg+1;
                residue--;
            }else {
                product *= avg;
            }
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }

}
