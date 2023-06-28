package lkhwtk.leetcode1116;

/**
 * 无锁方案，思路可以参考下，平台会报超时，重点参考ZeroEvenOdd
 */
public class ZeroEvenOdd2 {
    private int n;

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    volatile int stage = 0;

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++) {
            while(stage>0);
            printNumber.accept(0);
            if((i&1)==0) {
                stage = 1;
            }else {
                stage = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            while(stage!=2);
            printNumber.accept(i);
            stage = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            while(stage!=1);
            printNumber.accept(i);
            stage = 0;
        }
    }

}
