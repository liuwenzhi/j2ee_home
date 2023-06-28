package lkhwtk.leetcode706;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * 参考题解：官方，本题和705题实现类似，唯一不同点是存储的对象不同，这里存储一个键值对，单独建一个实体类即可。
 */
public class MyHashMap {

    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            //注意泛型在初始化时定义
            data[i] = new LinkedList<Pair>();
        }
    }

    /**模拟插入元素*/
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        //找到哈希key之后遍历下这个key后边的元素列表，是否包含这个值，包含的话就替换value
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        //原始序列不包含key的话，就在哈希key的位置列表最后插入记录
        data[h].offerLast(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                data[h].remove(pair);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
