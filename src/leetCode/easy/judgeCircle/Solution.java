package leetCode.easy.judgeCircle;

import java.util.*;

public class Solution {

    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) {
            return true;
        }
        if (moves.length() % 2 != 0) {
            return false;
        }
        int U = 0;
        int R = 0;
        for (int i = 0; i < moves.length(); i++) {
            char m = moves.charAt(i);
            switch (m) {
                case 'U':
                    U += 1;
                    break;
                case 'D':
                    U -= 1;
                    break;
                case 'L':
                    R += 1;
                    break;
                case 'R':
                    R -= 1;
                    break;
            }
        }
        System.out.println(U + "\t" + R);
        return U ==0 && R == 0;
    }

    public static void main(String[] args) {
        String moves = "LDRRLRUULR";
        System.out.println(new Solution().judgeCircle(moves));
    }
}
