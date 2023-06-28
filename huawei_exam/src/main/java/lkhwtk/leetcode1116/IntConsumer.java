package lkhwtk.leetcode1116;

/**
 * 这个IntConsumer是题目中自己调用ZeroEvenOdd类方法的自定义代码，
 * 本题不用管，这里写一个这个类就是配合代码别报错，实际输出不是走的自己写的run方法
 */
public class IntConsumer implements Runnable{

    private int num;
    public void accept(int num){
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(num);
    }
}
