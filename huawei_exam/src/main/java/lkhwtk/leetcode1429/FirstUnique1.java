package lkhwtk.leetcode1429;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 本题使用LinkedList队列实现，能通过90%的测试用例，最后边超大数据量的超时了。
 */
public class FirstUnique1 {

    /**存储数据主队列*/
    Deque<Integer> queue = new LinkedList<>();

    /**重复元素存储集合，本题只涉及查询和插入，不涉及删除，重复的元素直接放到*/
    Set<Integer> duplicatedSet = new HashSet<>();

    /**
     * 构造方法，初始化nums集合
     */
    public FirstUnique1(int[] nums) {
        for (int num : nums) {
            addInternal(num);
        }
    }

    public int showFirstUnique() {
        return queue.isEmpty() ? -1 : queue.peek();
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
        if(queue.contains(value)){
            queue.remove(value);
            duplicatedSet.add(value);
        }else{
            //set集合不包括这个值，再添加进去
            queue.offer(value);
        }
    }
    public void add(int value) {
        this.addInternal(value);
    }
}
