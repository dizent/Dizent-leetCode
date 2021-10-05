package LCP.game.weekCharacter;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 布谷
 * @Date: 2021/9/5 10:44
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        int[][] properties = {{1,5},{10,4},{4,3},{1,1},{2,9}};
        System.out.println(new Solution().numberOfWeakCharacters(properties));
    }


    public int numberOfWeakCharacters(int[][] properties) {
        Set<Integer> weekSet = new HashSet<>();

        for(int i = 0 ,n = properties.length ;i < n - 1 ;i++){

            for(int j = i + 1;j < n;j++){
                if(properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1]){
                    weekSet.add(j);
                }
                if(properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]){
                    weekSet.add(i);
                }
            }
        }
        System.out.println(JSONObject.toJSONString(weekSet));
        return weekSet.size();
    }

}
