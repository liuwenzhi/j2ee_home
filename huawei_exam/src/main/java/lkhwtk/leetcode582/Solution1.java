package lkhwtk.leetcode582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参考题解：官方
 * 对存储结构优化，不单独构建一棵树，通过一个hash表，key是val，值是children列表的方式来保存结构
 * 本题算法中采用深度优先遍历方式，广度优先遍历效率相对更低一点，先不看了。核心思路就是把子节点入队列
 */
public class Solution1 {
    public List <Integer> killProcess(List <Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<pid.size();i++){
            List <Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
            list.add(pid.get(i));
            map.put(ppid.get(i), list);
        }
        List <Integer> list = new ArrayList <>();
        list.add(kill);
        getAllChildren(map, list, kill);
        return list;
    }

    /**
     * 递归获取子节点，注意因为map的定义方式不同，这里和Solution的设计有不同
     */
    public void getAllChildren(Map<Integer,List< Integer >> map, List<Integer> list, int kill) {
        if (map.containsKey(kill)){
            for (int id: map.get(kill)) {
                list.add(id);
                getAllChildren(map, list, id);
            }
        }
    }

}
