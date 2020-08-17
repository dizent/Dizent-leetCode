package leetCode.easy.isPalindRome;

public class Solution {

    public boolean isPalindrome(int x) {
        int originX = x;
        if(x < 0 ){
            return false;
        }
        if(x < 10){
            return true;
        }
        int palind = 0;
        while(x > 0){
            palind *= 10;
            palind += x % 10;
            x /= 10;
        }
        return palind == originX ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1233221));
    }
}
