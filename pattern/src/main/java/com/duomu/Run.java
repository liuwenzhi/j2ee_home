package com.duomu;

public class Run {
    public static void main(String[] args){
        try{
            Stratch1 thread = new Stratch1();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
