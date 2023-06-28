package com.duomu;

public class TestThread extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(3000);
                System.out.println("t running");
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        //System.out.println("stop");
    }

}
