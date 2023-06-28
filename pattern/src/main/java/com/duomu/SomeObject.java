package com.duomu;

public class SomeObject {
    private final Object lock = new Object();
    private final Object lock1 = SomeObject.class;
    public void changeValue(){
        synchronized(lock1){

        }
    }
}
