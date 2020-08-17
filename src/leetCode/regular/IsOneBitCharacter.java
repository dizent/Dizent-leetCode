package leetCode.regular;

public class IsOneBitCharacter {

    public static void main(String[] args) {
        isOneBitCharacter(new int[]{1,1,0});
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int coutZero = 0;
        int countOne = 0;
        for (int i = bits.length - 1;i >= 0 ; i--) {
            if(bits[i] == 0 && i != bits.length -1){
                break;
            }
            if(bits[i] == 0){
                coutZero ++;
            }
            if(bits[i] == 1){
                countOne ++;
            }
        }
        if(coutZero > countOne){
            return true;
        }else if (countOne == coutZero){
            if(countOne == 1){
                return false;
            }else{
                return true;
            }
        }else{
            while(countOne >= 2) {
                countOne %=  2;
            }
            if(countOne == 0){
                return true;
            }else{
                return false;
            }
        }
    }

}
