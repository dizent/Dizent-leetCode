package nowcoder.numOfBanana;

/**
 * 有n个香蕉，每天吃一半加一个，第十天剩一个，求出n
 */
public class Solution {

    /**
     * 思路：
     *
     * 第一天剩 n / 2 -1 = m
     * 则前一天的香蕉数量 n = （m + 1） * 2
     * @return
     */
    public int numOfBanana(){
        int m = 1;
        for(int i = 9;i > 0;i--){
            m = (m+1) * 2;
            System.out.println("第 "+i+" 天:" + m);
        }

        return m;
    }


    public static void main(String[] args) {
        new Solution().numOfBanana();
    }
}
