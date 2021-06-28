package leetCode.easy.firstBadVersion;

public class Solution {

    int badVersion;

    public Solution(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version){
        return version >= badVersion;
    }

    public int firstBadVersion(int n) {
        int pre = 1,end = n,cur = end >> 1;
        while(true){
            if(end - pre < 4){
                for(int i = pre;i <= end;i++){
                    if(isBadVersion(i)){
                        return i;
                    }
                }
            }
            //当前版本为出错版本，向前二分
            if(isBadVersion(cur)){
                end = cur;
                cur = (pre >> 1) + (end >> 1);
            }else{
                //当前版本为正确版本，向后二分
                pre = cur;
                cur = (pre >> 1) + (end >> 1);
            }
        }
    }

    public int firstBadVersion2(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }



    public static void main(String[] args) {
        int version = 5;
        int badVersion = 1;
        System.out.println(new Solution(badVersion).firstBadVersion(version));
    }
}
