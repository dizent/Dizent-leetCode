package leetCode.regular.findRepeatedDnaSequences;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> results = new HashSet<>();
        Set<String> diffStr = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String findStr = s.substring(i, i + 10);
            if(diffStr.contains(findStr)){
                results.add(findStr);
            }else{
                diffStr.add(findStr);
            }

        }
        return new ArrayList<>(results);
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        List<String> result = new Solution().findRepeatedDnaSequences(s);
        System.out.println(JSONObject.toJSONString(result));
    }
}
