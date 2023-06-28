package lkhwtk.leetcode1226;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1226. 哲学家进餐
 * 参考题解：3种思路(互斥量 或 volatile + CAS)
 * 题解中一个明显错误，锁是多线程之间互斥通信的，不是多进程间的问题。
 * 本题核心思路：建立可重入锁数组，通过信号量控制最多持有叉子的人数
 */
public class DiningPhilosophers {
    //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
    private final ReentrantLock[] lockList = {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};

    //核心思路：限制 最多只有4个哲学家去持有叉子，只有四个许可证供获取和释放
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        //左边的叉子的编号，可以实际画一下，很好理解，左手边叉子是哲学家编号+1%5，右手边叉子是哲学家编号
        int leftFork = (philosopher + 1) % 5;
        //右边的叉子的编号
        int rightFork = philosopher;

        //限制的人数 -1，许可证减少一个
        eatLimit.acquire();

        //拿起左边的叉子
        lockList[leftFork].lock();
        //拿起右边的叉子
        lockList[rightFork].lock();
        //拿起左边的叉子 的具体执行
        pickLeftFork.run();
        //拿起右边的叉子 的具体执行
        pickRightFork.run();
        //吃意大利面 的具体执行
        eat.run();
        //放下左边的叉子 的具体执行
        putLeftFork.run();
        //放下右边的叉子 的具体执行
        putRightFork.run();
        //放下左边的叉子
        lockList[leftFork].unlock();
        //放下右边的叉子
        lockList[rightFork].unlock();

        eatLimit.release();//限制的人数 +1
    }

}
