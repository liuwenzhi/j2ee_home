package lkhwtk.offer09;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 参考题解：用两个栈实现队列 官方
 * 注意：本题精选题解中使用了addLast，removeLast等方法，不是正规的用栈来模拟队列
 */
public class CQueue {

    /**存放进入元素的栈*/
    private Stack<Integer> stackIn = null;

    /**存放弹出元素的栈*/
    private Stack<Integer> stackOut = null;

    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**入队模拟：直接进栈*/
    public void appendTail(int value) {
        stackIn.push(value);
    }

    /**出队模拟：入栈导出元素到出栈，弹出栈顶元素*/
    public int deleteHead() {
        //这个细节一定要注意：一定是stackOut是空的情况下才往里导入数据，否则直接pop即可
        if(stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        if(stackOut.isEmpty()){
            return -1;
        }else{
            return stackOut.pop();
        }
    }
}
