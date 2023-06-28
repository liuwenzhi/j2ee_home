package lkhwtk.leetcode652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 参考题解：官方
 * 核心思路：通过深度优先遍历，统计出每一个节点的深度序列，存放到map集合中，如果
 * 递归序列存在重复，则给出结果
 */
public class Solution {
    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) {
            //用*替换#，可能让耗时减少
            return "*";
            //return "#";
        }
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        //如果存在序列重复，则把根节点加入到ans队列中
        if (count.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
    }
}
