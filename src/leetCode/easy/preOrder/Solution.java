package leetCode.easy.preOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> preorder(Node root) {
        List result = new ArrayList();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.children != null) {
            for (Node ch : root.children) {
                result.addAll(preorder(ch));
            }
        }
        return result;

    }


}
