package leetCode.regular.ThroneInheritance;

import java.util.*;

public class ThroneInheritance {
    /**
     * 所有孩子节点
     */
    Map<String,List<String>> allChildren = new HashMap<>();
    /**
     *     死亡的孩子名字
     */
    Set<String> deadChildes = new HashSet<>();
    /**
     *     名字
     */
    String name;

    /**
     * 初始化一个 ThroneInheritance 类的对象。国王的名字作为构造函数的参数传入。
     * @param kingName
     */
    public ThroneInheritance(String kingName) {
        allChildren = new HashMap<String, List<String>>();
        deadChildes = new HashSet<String>();
        name = kingName;
    }

    /**
     * 表示 parentName 新拥有了一个名为 childName 的孩子。
     * @param parentName
     * @param childName
     */
    public void birth(String parentName, String childName) {
        List<String> children = this.allChildren.getOrDefault(parentName,new ArrayList<>());
        children.add(childName);
        this.allChildren.put(parentName,children);
    }


    /**
     * 表示名为 name 的人死亡。一个人的死亡不会影响 Successor 函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
     * @param name
     */
    public void death(String name) {
        this.deadChildes.add(name);
    }

    /**
     * 返回 除去 死亡人员的当前继承顺序列表。
     * @return
     */
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        //递归
        preorder(result,this.name);
        return result;
    }

    private void preorder(List<String> ans, String name) {
        if (!deadChildes.contains(name)) {
            ans.add(name);
        }
        List<String> children = allChildren.getOrDefault(name, new ArrayList<String>());
        for (String childName : children) {
            preorder(ans, childName);
        }
    }

}
