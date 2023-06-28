package lkhwtk.leetcode385;

import java.util.List;

public class NestedIntegerLocal implements NestedInteger{

    //Constructor initializes an empty nested list.
    public NestedIntegerLocal(){

    }

    // Constructor initializes a single integer.
    public NestedIntegerLocal(int value){

    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    /**
     * 解析单独一个整数的时候会用到，算法中对单独一个整数的情况直接调用带参构造方法返回了，这个方法在算法中实际没有用到
     */
    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
