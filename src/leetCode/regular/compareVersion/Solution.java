package leetCode.regular.compareVersion;

/**
 * @Auther: 布谷
 * @Date: 2021/9/1 12:26
 * @Description:
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int v1length = version1s.length;
        int v2length = version2s.length;
        int compare = 0;
        for (int i = 0;i < v1length || i < v2length; i ++){
            int v1 = i < v1length ? Integer.parseInt(version1s[i]) : 0;
            int v2 = i < v2length ? Integer.parseInt(version2s[i]) : 0;
            if(v1 < v2){
                compare = -1;
                break;
            }
            if(v1 > v2){
                compare =  1;
                break;
            }
        }
        return compare;
    }

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001.01";
        System.out.println(new Solution().compareVersion(version1,version2));
    }
}
