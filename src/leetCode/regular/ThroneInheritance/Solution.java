package leetCode.regular.ThroneInheritance;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONToken;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     *  ["ThroneInheritance","birth","birth","birth","birth","birth","birth","getInheritanceOrder","death","getInheritanceOrder"]
     *  [["king"],
     *  ["king","andy"],
     *  ["king","bob"],
     *  ["king","catherine"],
     *  ["andy","matthew"],
     *  ["bob","alex"],
     *  ["bob","asha"],
     *  [null],
     *  ["bob"],
     *  [null]
     *  ]
     */

    public static void main(String[] args) {
        ThroneInheritance tNode = new ThroneInheritance("king");
        tNode.birth("king","andy");
        tNode.birth("king","bob");
        tNode.birth("king","catherine");
        tNode.birth("andy","matthew");
        tNode.birth("bob","alex");
        tNode.birth("bob","asha");
        System.out.println(JSONObject.toJSONString(tNode.getInheritanceOrder()));
        tNode.death("bob");
        System.out.println(JSONObject.toJSONString(tNode.getInheritanceOrder()));
    }
}
