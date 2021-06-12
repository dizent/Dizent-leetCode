package leetCode.diffcault.canCross;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示），请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时，青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了k个单位，那么它接下来的跳跃距离只能选择为k - 1、k或k + 1 个单位。另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 * 示例 2：
 *
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 */
public class Solution {

    /**
     * 使用回溯法
     *
     * 1. 第一步为 0 - > 1 固定；步幅为 1
     * 2. 第二步可以选择步幅为 0 - 2；
     * 3. 判断 步幅 - 1 是否可以跳到下一块石头，如果可以，则继续判断
     * 4. 如果不行，则判断步幅继续，是否可以
     * 5. 一直判断到最后一块石头，直接返回true
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        if(stones[1] != 1){
            return false;
        }
        Map<Integer,Boolean> booleans = new HashMap<>();
        return canCross(stones,0,0,booleans);
    }

    /**
     *
     * @param stones 石头位置数组
     * @param k 上次的步幅
     * @param index 当前所在位置的石头下标
     * @return
     */
    public boolean canCross(int[] stones,int index,int k,Map<Integer,Boolean> bool){
        int key = index * 1000 + k;
        if(bool.get(key)){
            return false;
        }else{
            bool.put(key,true);
        }
        for(int i = index + 1;i< stones.length ;i ++){
            int gap = stones[i] - stones[index];
            if(gap >= k-1 && gap <= k+1) {
                if (canCross(stones, i, gap, bool)) {
                    return true;
                }
            }else if(gap > k +1){
                break;
            }
        }
        return index == stones.length - 1;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        new Solution().canCross(stones);
    }
}
