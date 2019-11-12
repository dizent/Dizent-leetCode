package leetCode;


public class LeetCode {

    public void testLeetCode(){
        String str = addBinary("1011","1010");
        System.out.println(str);
    }

    public String addBinary(String a, String b) {
        char[] aArry = a.toCharArray();
        char[] bArry = b.toCharArray();
        char[] cArry = new char[Math.max(aArry.length, bArry.length)];
        boolean carry = false ;
        boolean fCarry = false;
        for(int i = aArry.length - 1,j=bArry.length - 1 ,l = cArry.length - 1;i >= 0 || j >= 0; i--,j--,l--){
            char ac = 0;
            char bc = 0;
            if( i < 0 ){
                ac = 48;
            }else{
                ac = aArry[i];
            }
            if(j < 0){
                bc = 48;
            }else{
                bc = bArry[j];
            }
            if(carry){
                ac += 1;
                carry = false;
            }
            int c = ac + bc;
            if(c >= 98){
                carry = true;
                c -= 2;
                if(l == 0){
                    fCarry = true;
                }
            }
            c -= 48;
            cArry[l] = (char) c;
        }
        String result = new String(cArry);
        if(fCarry){
            result = "1"+result;
        }
        return result;
    }
}
