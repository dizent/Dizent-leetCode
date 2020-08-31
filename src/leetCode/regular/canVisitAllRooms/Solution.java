package leetCode.regular.canVisitAllRooms;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * <p>
 * 1 <= rooms.length <=1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过3000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 */
public class Solution {

    static int[] canVisits;

    /**
     * 思路：
     *
     * 定义一个和房间个数长度相同的数组，用于存放已经访问过的房间。当房间访问过之后，对应位置的元素值改为1
     * 访问第一个房间，拿到房间里面的钥匙
     *
     * 深度优先遍历：
     *  + 拿到第一个钥匙，修改数组对应位置的值。进入对应的房间
     *  + 进入对应房间之后，拿到钥匙，再进行递归
     *  + 一直到无法进入下一个房间时，开始使用上一个房间的后一个钥匙
     *  + 当后一个房间已经被访问过，则不再重复访问
     *
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        canVisits = new int[rooms.size()];
        canVisits[0] = 1;
        dfs(rooms, rooms.get(0));
        for(int i = 0;i< canVisits.length;i++){
            if(canVisits[i] == 0){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> rooms, List<Integer> room) {
        for (int i = 0; i < room.size(); i++) {
            if (canVisits[room.get(i)] == 0) {
                canVisits[room.get(i)] = 1;
                dfs(rooms, rooms.get(room.get(i)));
            }else{
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "[[1,3],[3,0,1],[2],[0]]";
        List<List<Integer>> rooms = JSONObject.parseObject(input, new TypeReference<List<List<Integer>>>() {
        });
        System.out.println(new Solution().canVisitAllRooms(rooms));
    }
}
