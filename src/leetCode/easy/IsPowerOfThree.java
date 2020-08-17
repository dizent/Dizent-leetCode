package leetCode.easy;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * 3的幂
 */
public class IsPowerOfThree {
    public static boolean function(int n){
        if(n == 0){
            return false;
        }
        while(n > 1){
            if(n % 3 != 0){
                return false;
            }else{
                n /= 3;
            }
        }
        return true;
    }


    public static boolean higherFunction(int n){
        String str = Integer.toString(n,3);
        return str.matches("^10*$");
    }


    public static void main(String[] args) {
        System.out.println(higherFunction(27));
    }
}
