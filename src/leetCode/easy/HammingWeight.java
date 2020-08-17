package leetCode.easy;

public class HammingWeight {
    public static int function(int n){
        return Integer.toString(n,2).replaceAll("0","").length();
    }

    public static void main(String[] args) {
        System.out.println(function(Integer.parseInt("11111111111111111111111111111101")));
    }
}
