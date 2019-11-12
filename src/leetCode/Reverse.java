package leetCode;

public class Reverse {

    public void testRe(){
        System.out.println(reverse(1534236469));
    }

    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        char[] charStr = str.toCharArray();
        int lastIndex = 0;
        if(x < 0){
            lastIndex = 1;
            sb.append("-");
        }
        for(int i = charStr.length - 1;i >= lastIndex; i--){
            sb.append(charStr[i]);
        }
        try{
            return Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
