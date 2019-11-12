package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IsVaild {

    public boolean function(String s){
        Stack<Character> stack = new Stack<Character> ();
        List<Character> left = Arrays.asList('{','[','(');
        List<Character> right = Arrays.asList('}',']',')');
        char[] schar = s.toCharArray();
        for(char c:schar){
            if(stack.empty()){
                stack.push(c);
            }else{
                if(left.contains(c)){
                    stack.push(c);
                }else if(right.contains(c)){
                    char tmp = stack.peek();
                    if(left.indexOf(tmp) == right.indexOf(c)){
                        stack.pop();
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty() || s.length() == 0) {
            return true;
        }
        return false;
    }
}
