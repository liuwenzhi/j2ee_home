package lkhwtk.leetcode1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1114. 按序打印
 * 参考题解：官方
 */
public class Foo {

    /**
     * 定义原子变量标记
     */
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //原子变量自增
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(firstJobDone.get()!=1){
            //等待
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            //等待
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
