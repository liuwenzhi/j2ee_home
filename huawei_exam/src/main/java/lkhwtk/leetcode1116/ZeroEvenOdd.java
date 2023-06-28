package lkhwtk.leetcode1116;

import java.util.concurrent.Semaphore;

/**
 * 1116. 打印零与奇偶数
 * 参考题解：JAVA并发工具类大练兵
 * 本题重点参考这个思路
 */
public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    /**初始化0许可证信号量，包含1个许可证，保证一开始能够直接执行，后边需要有z.release执行之后，才能继续执行*/
    Semaphore z = new Semaphore(1);
    /**初始化奇数许可证信号量，包含0个许可证，一开始会被阻塞，直到许可被释放之后才会执行代码逻辑*/
    Semaphore e = new Semaphore(0);
    /**初始化偶数许可证信号量，包含0个许可证，一开始会被阻塞，知道许可被释放之后才会执行代码逻辑*/
    Semaphore o = new Semaphore(0);

    //注意题目中注释： printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<n;i++) {
            //acquire() 获取一个许可,如果没有就等待
            z.acquire();
            printNumber.accept(0);
            if((i&1)==0) {
                //release() 释放一个许可，偶数情况o释放一个许可证，二进制偶数肯定以0结尾
                o.release();
            }else {
                //奇数情况e释放一个许可证
                e.release();
            }
        }
    }

    /**
     * 输出偶数，从2开始
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            //由于信号量e设置许可证数量是0，acquire之后，会变成-1，这个时候该线程被阻塞住
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    /**
     * 输出奇数，从1开始
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            //由于信号量0设置许可证数量是0，acquire之后，会变成-1，这个时候该线程被阻塞住
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
