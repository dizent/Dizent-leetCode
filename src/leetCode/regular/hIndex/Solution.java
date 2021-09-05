package leetCode.regular.hIndex;

/**
 * @Auther: 布谷
 * @Date: 2021/7/12 14:49
 * @Description:
 */
public class Solution {

    public int hIndex(int[] citations) {
        if(citations.length == 0){
            return 0;
        }
        int l = 0;
        int r = citations.length - 1;
        int size = citations.length;
        int h = halfSearch(citations,l,r,size);
        return h;
    }

    public int halfSearch(int[] citations,int l,int r,int size){
        int mid = (r - l) / 2 + l;
        int h = size - mid;
        if(r - l < 1){
            if(citations[mid] >= h){
                return h;
            }
            return h - 1;
        }
        if(citations[mid] >= h){
            return halfSearch(citations,l,mid - 1,size);
        }
        return halfSearch(citations,mid + 1,r,size);
    }

    public static void main(String[] args) {
        int[] citations = {
                10,11,12,13,15
        };
        System.out.println(new Solution().hIndex(citations));
    }
}
