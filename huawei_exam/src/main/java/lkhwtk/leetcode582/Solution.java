package lkhwtk.leetcode582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 582. 杀掉进程
 * 参考题解：官方
 */
public class Solution {
    /**
     * 构建一棵树，直接构建树效率比较低，主要是空间复杂度稍微高一些
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //通过一个map集合存储全部node节点
        Map<Integer,TreeNode> map = new HashMap<>();
        //将pid中全部元素封装成TreeNode节点，然后放到map中，这样在简历父子节点关系的时候，就能通过map直接get到
        for(int id:pid){
            TreeNode node = new TreeNode();
            node.setVal(id);
            map.put(id,node);
        }
        //根据ppid建立节点的父子关系，这里需要通过循环i的方式，因为需要同时遍历pid和ppid两个集合
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                TreeNode parent = map.get(ppid.get(i));
                parent.getChildren().add(map.get(pid.get(i)));
            }
        }
        List < Integer > list = new ArrayList<>();
        list.add(kill);
        getAllChildren(map.get(kill), list);
        return list;
    }

    /**
     * 遍历全部叶子节点，需要使用递归的方式
     */
    public void getAllChildren(TreeNode parent, List <Integer> list) {
        for (TreeNode node: parent.getChildren()) {
            list.add(node.getVal());
            getAllChildren(node, list);
        }
    }

}
