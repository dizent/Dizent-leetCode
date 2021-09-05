package newcoder.offerSword;

import java.security.InvalidParameterException;

class Foo {

    public static void main(String[] args) {
        cmp("aaa","bbb");
    }

    static boolean cmp(String a, String b){
        boolean ret = false;
        if(a == null || b == null)
            throw new InvalidParameterException();

        ret = (a == b);
        return ret;
    }

}
