package com.duomu.hj49;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
 * 接口说明：
 * void init();  //初始化函数
 * void Release(); //资源释放函数
 * unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
 * unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
 * unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
 * Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
 * char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
 *
 * 输入描述:
 * 本题含有多个样例输入。
 * 输入一个int整数
 *
 * 输出描述:
 * 对于每组样例，输出多个ABCD
 *
 * 示例1
 * 输入
 * 复制
 * 10
 * 输出
 * 复制
 * ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int n = Integer.parseInt(line);
            CountDownLatch countDownLatch = new CountDownLatch(4);
            AlternativePrint alternativePrint = new AlternativePrint();
            //创建四个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printA();
                        }
                    } finally {
                        //计数器执行-1操作
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printB();
                        }
                    } finally {
                        //计数器执行-1操作
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printC();
                        }
                    } finally {
                        //计数器执行-1操作
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printD();
                        }
                    } finally {
                        //计数器执行-1操作
                        countDownLatch.countDown();
                    }
                }
            }).start();
            try {
                /*计数器进入等待状态，countDownLatch.countDown()执行4次之后，等于0了，触发接下来的代码
                采用countDownLatch起到一个全部线程都输出完事之后，再换行的效果，最后结果没有换行会运行失败*/
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
/**
 * 一个类四个方法，分别打印ABCD，可以被四个线程调用这四个方法
 * 注意一个重要的点：需要在调用wait()或者notify()之前，必须使用synchronized语义绑定住被wait/notify的对象。不然就会报诡异的：java.lang.IllegalMonitorStateException
 * AlternativePrint类中，Condition对象就是通信的对象，作为原始的wait和notify的替代，一定要做同步控制。想深入了解可以百度看源码。有一个点：代码中抛出异常的时候，
 * 牛客的控制台都是提示：请检查是否存在数组越界等非法访问情况，注意等这个字，实际所有的异常都会这么提示。本题能看到具体异常信息，正式考试看不到，但是有个认识，
 * 肯定是抛异常了。
 */
class AlternativePrint {
    //ReentrantLock起到一个各自代码块加锁的作用，
    private Lock lock = new ReentrantLock();
    //Condition是核心，通过lock对象创建，线程间相互通信通过Condition变量，替代wait和notify
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();
    //通信变量，涉及到多线程多个方法对这个变量的操作，通过通信变量初始值1来printA方法先执行，避免循环等待
    private int number = 1;

    void printA() {
        lock.lock();
        try {
            if (number != 1) {
                conditionA.await();
            }
            System.out.print("A");
            //"A"打印结束，标记置为2，并唤醒打印"B"的线程
            number = 2;
            //唤醒conditionB
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printB() {
        lock.lock();
        try {
            if (number != 2) {
                conditionB.await();
            }
            System.out.print("B");
            //"B"打印结束，标记置为3，并唤醒打印"C"的线程
            number = 3;
            //唤醒conditionC
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printC() {
        lock.lock();
        try {
            if (number != 3) {
                conditionC.await();
            }
            System.out.print("C");
            //"C"打印结束，标记置为4，并唤醒打印"D"的线程
            number = 4;
            conditionD.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printD() {
        lock.lock();
        try {
            if (number != 4) {
                conditionD.await();
            }
            System.out.print("D");
            //"D"打印结束，标记置为1，并唤醒打印"A"的线程
            number = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
