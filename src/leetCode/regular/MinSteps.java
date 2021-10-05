package leetCode.regular;


public class MinSteps {

    public void testMin(){
        System.out.println(minSteps(45));
    }

    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinSteps().minSteps(30));
    }
}
