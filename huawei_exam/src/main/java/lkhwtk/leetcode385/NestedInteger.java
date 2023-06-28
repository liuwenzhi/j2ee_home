package lkhwtk.leetcode385;

import java.util.List;

/**
 * NestedInteger在本地的工具类，本体在本地调试不了，这个工具接口告知能干什么事情
 */
public interface NestedInteger {
    //Constructor initializes an empty nested list.
   //public NestedInteger();

   // Constructor initializes a single integer.
   //public NestedInteger(int value);

   // @return true if this NestedInteger holds a single integer, rather than a nested list.
   //如果当前对象是一个整数而不是一个列表，返回true
   public boolean isInteger();

   // @return the single integer that this NestedInteger holds, if it holds a single integer
   // Return null if this NestedInteger holds a nested list
   //返回当前对象的整数值，如果对象包括一个列表，而不是一个整数值则返回null
   public Integer getInteger();

   // Set this NestedInteger to hold a single integer.
   //将当前NestedInteger存放一个整数
   public void setInteger(int value);

   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
   //将当前NestedInteger存放一个列表，然后向这个列表中加入一个整数
   public void add(NestedInteger ni);

   // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return empty list if this NestedInteger holds a single integer
   //返回NestedInteger对象列表，如果NestedInteger对象只有一个整数值，而不是列表则返回空列表
   public List<NestedInteger> getList();
}
