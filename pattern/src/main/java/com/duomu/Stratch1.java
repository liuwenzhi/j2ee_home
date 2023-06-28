package com.duomu;

public class Stratch1 extends Thread{
    private volatile boolean isRunning = true;
    public boolean isRunning(){
        return isRunning;
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("begin");
        while(isRunning){

        }
        System.out.println("end");
    }
}
