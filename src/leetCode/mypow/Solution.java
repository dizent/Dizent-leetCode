package leetCode.mypow;

public class Solution {


    public double myPow(double x, int n) {
        double result = 1.0;
        for(int i = n;i !=0 ;i /=2 ){
            if(i % 2 != 0){
                result *= x;
            }
            x *= x;
        }
        return n >= 0 ? result : 1/result;
    }

    public static void main(String[] args) {
        long startSys = System.currentTimeMillis();
        System.out.println(Math.pow(2.00000,-2147483647));
        long endSysStartself = System.currentTimeMillis();
        System.out.println(new Solution().myPow(2.00000,-2147483647));
        long endSelf = System.currentTimeMillis();
        System.out.println("sys \t"+ (endSysStartself-startSys) + "\tself\t" + (endSelf - endSysStartself));

    }
}
