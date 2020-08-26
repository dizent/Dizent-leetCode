package leetCode.easy.repeatedSubstringPattern;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        Integer size = s.length();
        for(int i = 2;i <= size ;i ++){
            if(size % i == 0) {
                String sonStr = s.substring(0, size / i);
                System.out.println(sonStr);
                Integer index = 0;
                Integer fromIndex = 0;
                while(true){
                    index = s.indexOf(sonStr,fromIndex);
                    if(index == -1 || index > fromIndex){
                        break;
                    }
                    if(index + sonStr.length() == size) {
                        return true;
                    }
                    fromIndex += sonStr.length();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "aba";
        System.out.println(new Solution().repeatedSubstringPattern(str));
    }
}
