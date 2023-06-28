package lkhwtk.leetcode705;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 参考题解：官方：题解对哈希集合底层实现等做了简单阐述，核心思路围绕主题明确，设计了链地址法处理哈希冲突
 */
public class MyHashSet {
    /**
     * hashSet最大长度，设计为一个质数，当长度超过该范围，则采用链地址法进行key的冲突处理
     */
    private static final int BASE = 769;

    /**
     * 核心数据结构，定义一个单链表数组，具体泛型在初始化时定义
     */
    private LinkedList[] data;

    /**
     * 初始化单链表数组.
     */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            //注意：泛型在初始化时指定
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        //获取key对应的哈希值，然后在data数组中找到这个链表，获取他全部元素
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            //如果获取这个集合的过程中，发现有这个key，就直接返回，起到Set集合去重的效果
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        //在单链表LinkedList的尾部插入key
        data[h].offerLast(key);
    }

    public void remove(int key) {
        //获取key对应的哈希值，然后在data数组中找到这个链表，获取他全部元素
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            //获取元素的时候如果发现了这个key，则直接删除掉
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /**
     * 在数组中寻找key方式和添加删除类似，找到数组中这个元素的哈希位置，然后遍历全部元素，找到这个值
     */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希地址计算方式，通过key值对BASE取余
     */
    private static int hash(int key) {
        return key % BASE;
    }

}
