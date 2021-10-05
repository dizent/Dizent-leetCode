package other.timeLine;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: 布谷
 * @Date: 2021/9/23 15:31
 * @Description:
 */
public class ReplaceSolution {

    public static void main(String[] args) {
        String condVal = "java${begin}替换测试，{0}行不行，{0}可以的";
        LocalDateTime begin = LocalDateTime.now();
        String beginStr = begin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String value = Parser.parse0(condVal,beginStr);
        System.out.println(value);
    }
}
