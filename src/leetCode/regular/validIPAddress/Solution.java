package leetCode.regular.validIPAddress;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或IPv6 地址。
 *
 * IPv4地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为0 -255，用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址172.16.254.01 是不合法的。
 *
 * IPv6地址由8组16进制的数字来表示，每组表示16 比特。这些组数字通过 (":")分割。比如,2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以，2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。比如，2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如，02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 说明:你可以认为给定的字符串里没有空格或者其他特殊字符。
 *
 * 示例 1:
 *
 * 输入: "172.16.254.1"
 *
 * 输出: "IPv4"
 *
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 *
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * 输出: "IPv6"
 *
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 *
 * 输入: "256.256.256.256"
 *
 * 输出: "Neither"
 *
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 *
 */
public class Solution {

    /**
     * 解题思路
     *
     * 1. 分别判断字符串是否为"IPv4"以及"IPv6"
     *  + IPv4:
     *      - 首先判断整体字符串格式，是否有多余的分隔符 . 号
     *      - 将字符串分隔为多个子串，并判断子串个数是否为4
     *      - 分别判断每个子串：子串长度是否在1-3之间，判断是否为0
     *      - 判断不为0时，是否以 0 作为开头
     *      - 正则判断是否为正整数，并且是否小于 255
     *  + IPv6
     *      - 首先判断整体字符串格式，是否有多余的分隔符 ： 号
     *      - 将字符串分隔为多个子串，并判断子串个数是否为 8
     *      - 正则判断是否为正确的 IPv6 子串
     *
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if(isIPV4(IP)){
            return "IPv4";
        }if(isIPV6(IP)){
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPV4(String ip) {
        if(ip.endsWith(".") || ip.startsWith(".")){return false;}
        String[] sonIP = ip.split("\\.");
        if(sonIP.length != 4){return false;}
        String regex = "^[1-9]\\d*$";
        for(String sonStr:sonIP){
            if(sonStr.length() == 0 || sonStr.length() > 3){
                return false;
            }
            if("0".equals(sonStr)){
                continue;
            }
            if("0".equals(sonStr.substring(0,1)) && sonStr.length() != 1){
                return false;
            }
            if(!sonStr.matches(regex)){
                return false;
            }
            if(Integer.parseInt(sonStr) > 255){
                return false;
            }
        }
        return true;
    }

    private boolean isIPV6(String ip) {
        if(ip.endsWith(":") || ip.startsWith(":")){return false;}
        String[] sonIP = ip.split(":");
        if(sonIP.length != 8){return false;}
        String regex = "^[0-9a-fA-F]{1,4}$";
        for(String sonStr:sonIP){
            if(!sonStr.matches(regex)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(new Solution().validIPAddress(IP));
    }
}
