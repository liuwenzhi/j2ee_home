package lkhwtk.leetcode1429;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1429. 第一个唯一数字
 * 参考题解：LinkedHashSet + HashSet 简单实现
 */
public class FirstUnique {

    /**存储主集合，LinkedHashSet能够去重，同时保证顺序*/
    LinkedHashSet<Integer> set = new LinkedHashSet<>();

    /**重复元素存储集合，本题只涉及查询和插入，不涉及删除，重复的元素直接放到*/
    Set<Integer> duplicatedSet = new HashSet<>();

    /**
     * 构造方法，初始化nums集合
     */
    public FirstUnique(int[] nums) {
        for (int num : nums) {
            addInternal(num);
        }
    }

    public int showFirstUnique() {
        return set.isEmpty() ? -1 : set.iterator().next();
    }

    /**
     * 向集合中添加元素
     */
    private void addInternal(int value) {
        //如果重复集合中包括了这个值，则直接返回
        if(duplicatedSet.contains(value)){
            return;
        }
        //如果set集合包括这个值，则set删除这个值，重复集合中加入这个值
        if(set.contains(value)){
            set.remove(value);
            duplicatedSet.add(value);
        }else{
            //set集合不包括这个值，再添加进去
            set.add(value);
        }
    }
    public void add(int value) {
        this.addInternal(value);
    }
}
