package leetCode.regular;


public class IsPalindrome {

    public void test(){
        System.out.println(isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] charstr = str.toCharArray();
        for(int i = 0,j = charstr.length -1;i <= charstr.length / 2 && j >= charstr.length / 2; i++,j--){
            if(charstr[i]!=charstr[j]){
                    return false;
            }
        }
        return true;
    }
}
