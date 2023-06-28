package com.art.concurrency.unit1;

/**
 * java并发编程的艺术，第一章，ConcurrencyTest 代码
 */
public class ConcurrencyTest {
    private static final long count = 100000000L;

    public static void main(String[] args)throws InterruptedException{
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                int a = 0;
                for(long i=0;i<count;i++){
                    a+=5;
                }
            }
        });
        thread.start();
        int b = 0;
        for(long i=0;i<count;i++){
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency:"+time+"ms,b="+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i=0;i<count;i++){
            a+=5;
        }
        int b = 0;
        for(long i=0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:"+time+"ms,b="+b+",a="+a);
    }
}
