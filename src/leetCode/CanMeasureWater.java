package leetCode;

import java.util.Stack;

public class CanMeasureWater {
    public static boolean function(int x,int y,int z){
        if(z==0)return true;
        if(x+y<z)return false;
        if(x>y){int temp = x;x=y;y=temp;}
        if(x==0)return y==z;
        while(y%x!=0){
            int temp = y;
            y = x;
            x = temp%x;
        }
        return z%x==0;
    }

    public static void main(String[] args) {
        System.out.println(function(0,0,1));
    }
}
