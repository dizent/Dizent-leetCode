package newcoder.getHint;

/**
 *
 */
public class Solution {

    /**
     * 先找到位置和数字都对的数字。
     * 去除上述数字之后，再找位置不对的。
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        for(int i = 0;i<secret.length() ;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls += 1;
                guess = guess.replaceFirst(String.valueOf(secret.charAt(i)),"g");
                secret = secret.replaceFirst(String.valueOf(secret.charAt(i)),"s");
            }
        }
        int cows = 0;
        for(int i = 0;i<guess.length();i++){
            for(int j = 0;j<secret.length();j++){
                if(secret.charAt(j) == guess.charAt(i)){
                    cows += 1;
                    guess = guess.replaceFirst(String.valueOf(guess.charAt(i)),"g");
                    secret = secret.replaceFirst(String.valueOf(secret.charAt(j)),"s");
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String secret = "1123";
        String guess = "0111";
        System.out.println(solution.getHint(secret,guess));
    }
}
