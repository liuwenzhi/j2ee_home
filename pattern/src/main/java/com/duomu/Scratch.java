package com.duomu;

public class Scratch extends Thread{
    private boolean stop = false;
    public static void main(String[] args)throws InterruptedException{
        //Scratch t = new Scratch();
        TestThread t = new TestThread();
        t.start();
        //Thread.sleep(3000);
        t.interrupt();
        //Thread.sleep(3000);
        System.out.println("exit");
    }

    @Override
    public void run() {
        while(!stop){
            System.out.println("running");
        }
        System.out.println("stop");
    }
}
