package leetCode.easy.getLastNum;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public Integer getLastNUm(String str){

        String regex = "[0-9]{1,10}";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        List<String> matchStrs = new ArrayList<>();
        while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchStrs.add(matcher.group());//获取当前匹配的值
        }
        return Integer.valueOf(matchStrs.get(matchStrs.size()-1));

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getLastNUm("满100减20元优惠券"));
    }
}
