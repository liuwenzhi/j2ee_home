package lkhwtk.leetcode706;

/**
 * 键值对实体类
 */
public class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
