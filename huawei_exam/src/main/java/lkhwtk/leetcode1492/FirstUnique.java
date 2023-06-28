package lkhwtk.leetcode1492;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1429. 第一个唯一数字
 * 考虑一个简单思路：设计两个set，一个是普通的hashSet，一个是LinkedHashSet，
 * LinkedHashSet便于插入和删除元素，存放唯一值，另外一个普通hashSet，存放其
 * 他的重复的值
 */
public class FirstUnique {
    /**LinkedHashSet能保持有序和去重，同时基于链表结果方便插入和删除数据*/
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    /**普通HashSet只能去重*/
    Set<Integer> deletedSet = new HashSet<>();
    public FirstUnique(int[] nums) {
        for (int num : nums)
            this.addInternal(num);
    }

    public int showFirstUnique() {
        return set.isEmpty() ? -1 : set.iterator().next();
    }
    private void addInternal(int value) {
        //这个细节很必要，如果要插入的值，在HashSet里边有，就不插入了，避免多个重复数值的插入影响结果
        if(deletedSet.contains(value)) return;
        //如果要插入的值在LinkedHashSet集合中存在，则直接把这个数据从LinkedHashSet集合里边删除，放到hashSet里边
        if(set.contains(value)){
            set.remove(value);
            deletedSet.add(value);
        }else{
            //如果这个值在LinkedHashSet里边不存在，则放到LinkedHashSet中
            set.add(value);
        }
    }
    public void add(int value) {
        this.addInternal(value);
    }


}
