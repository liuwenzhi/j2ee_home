package com.duomu.hj49;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Main1 {
    static List<Character> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            final int total = scanner.nextInt();
            results = new ArrayList<>();
            Lock lock = new ReentrantLock();
            Condition[] conditions = {
                    lock.newCondition(),
                    lock.newCondition(),
                    lock.newCondition(),
                    lock.newCondition()
            };
            final Future<Boolean>[] taskResult = new Future[1];
            ExecutorService executor = Executors.newFixedThreadPool(4);
            IntStream.rangeClosed(0, 3).forEach(it -> {
                taskResult[0] = executor.submit(new Task(lock, conditions[it], conditions[it == 3 ? 0 : it + 1], total, it));
            });
            executor.shutdown();
            try {
                if (taskResult[0].get(2, TimeUnit.SECONDS)) {
                    for (Character item : results) {
                        System.out.print(item);
                    }
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task implements Callable<Boolean> {

        static char[] WORDS = {'A', 'B', 'C', 'D'};

        int count;

        Condition conSelf;

        Condition conTarget;

        int index;

        Lock lock;

        Task(Lock lock, Condition conSelf, Condition conTarget, int count, int index) {
            this.lock = lock;
            this.count = count;
            this.conSelf = conSelf;
            this.conTarget = conTarget;
            this.index = index;
        }

        public Boolean call() {
            while (count > 0) {
                try {
                    lock.lock();
                    while (results.size() % WORDS.length != index) {//弃锁条件
                        conSelf.await();
                    }
                    results.add(WORDS[index]);
                    count--;
                    conTarget.signal(); //唤醒等待此condition的线程
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            return true;
        }
    }
}
