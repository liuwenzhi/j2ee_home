package com.duomu;

public interface A {
    default public void test(){
        System.out.println("Hello world");
    }
}
